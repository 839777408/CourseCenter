package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dao.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.dto.SelectCourse;
import top.nanzx.entity.Course;
import top.nanzx.entity.Means;
import top.nanzx.entity.Teacher;
import top.nanzx.entity.Video;
import top.nanzx.service.TeacherService;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Nan
 * @Date: Created in 13:26 2021/1/24
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private DtoDao dtoDao;
    @Autowired
    private FileDao fileDao;
    @Value("${multipartFile.path}")
    private String filePath;

    @Override
    public JsonResult validateLogon(HashMap<String, String> map) {
        String no = map.get("username");
        String password = map.get("password");
        Teacher teacher = teacherDao.validateLogon(no, password);
        if (teacher == null) {
            return new JsonResult(1, "登录失败，请检查工号和密码是否输入有误！", null);
        } else {
            ConcurrentHashMap<String, String> returnMap = new ConcurrentHashMap<>();
            returnMap.put("no", teacher.getNo());
            returnMap.put("name", teacher.getName());
            returnMap.put("squad", "");
            return new JsonResult(0, "登录成功！", returnMap);
        }
    }

    @Override
    public JsonResult createCourse(HashMap<String, String> map) {
        String courseName = map.get("courseName");
        String imgUrl = map.get("imgUrl");
        String notice = map.get("notice");
        String intro = map.get("intro");
        String no = map.get("no");
        Date date = new Date();

        Course course = new Course();
        course.setCourseName(courseName);
        course.setImgUrl(imgUrl);
        course.setNotice(notice);
        course.setIntro(intro);
        Teacher teacher = new Teacher();
        teacher.setNo(no);
        course.setTeacher(teacher);
        course.setActivity(1);
        course.setCreateTime(date);

        Boolean flag1 = courseDao.createCourse(course);

        if (flag1) {
            String classes = map.get("classes");
            Integer id = course.getId();
            String[] squadList = classes.split(",");
            for (String squad : squadList) {
                dtoDao.createSelectCourse(id, squad);
            }
            return new JsonResult(0, "创建课程成功！", null);
        } else {
            return new JsonResult(1, "创建课程失败！", null);
        }
    }

    @Override
    public JsonResult uploadFile(MultipartFile file, int courseId) {
        if (file == null || file.isEmpty()) {
            return new JsonResult(1, "未选择需上传的文件", null);
        }

        String originalFilename = file.getOriginalFilename();
        Means means = fileDao.queryMean(originalFilename, courseId);
        if (means != null) {
            return new JsonResult(1, "该课程下已有重复文件名！", null);
        }

        File dest = new File(filePath + '\\' + courseId + '\\' + originalFilename);
        if (!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
            if (!mkdirs) {
                return new JsonResult(1, "文件路径异常，请联系管理员。", null);
            }
        }
        try {
            file.transferTo(dest);
            means = new Means();
            Course course = new Course();
            course.setId(courseId);

            means.setCourse(course);
            means.setFileName(originalFilename);
            means.setUploadTime(new Date());
            //单位是MB
            means.setSize(new BigDecimal(file.getSize()).divide(new BigDecimal("1048576"), 2, BigDecimal.ROUND_HALF_UP));

            fileDao.addMean(means);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "文件上传失败。", null);
        }
        return new JsonResult(0, "文件上传成功！", null);
    }

    @Override
    public JsonResult uploadVideo(MultipartFile file, int courseId) {
        if (file == null || file.isEmpty()) {
            return new JsonResult(1, "未选择需上传的文件", null);
        }

        String originalFilename = file.getOriginalFilename();
        Video video = fileDao.queryVideo(originalFilename, courseId);
        if (video != null) {
            return new JsonResult(1, "该课程下已有重复文件名！", null);
        }

        File dest = new File(filePath + '\\' + courseId + '\\' + '\\' + "video" + '\\' + originalFilename);
        if (!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
            if (!mkdirs) {
                return new JsonResult(1, "文件路径异常，请联系管理员。", null);
            }
        }
        try {
            file.transferTo(dest);
            video = new Video();
            Course course = new Course();
            course.setId(courseId);

            video.setCourse(course);
            video.setFileName(originalFilename);
            video.setUploadTime(new Date());
            //单位是位
            video.setSize((int) file.getSize());

            fileDao.addVideo(video);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "文件上传失败。", null);
        }
        return new JsonResult(0, "文件上传成功！", null);
    }

    @Override
    public JsonResult delMain(String courseId, String fileName) {
        File file = new File(filePath + '\\' + courseId + '\\' + fileName);
        if (file.isFile() && file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                fileDao.delMean(Integer.parseInt(courseId), fileName);
                return new JsonResult(0, "文件删除成功。", null);
            } else {
                return new JsonResult(1, "文件删除失败。", null);
            }
        }
        return new JsonResult(1, "文件删除失败。", null);
    }

    @Override
    public JsonResult getCourses(String no) {
        List<SelectCourse> list = new ArrayList<>();

        List<Course> courses = courseDao.getCoursesByTeacherNo(no);
        for (Course course : courses) {
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setCourse(course);

            List<String> squadsList = dtoDao.getSquadsByCourse(course.getId());
            StringBuilder squads = new StringBuilder();
            for (int i = 0; i < squadsList.size(); i++) {
                if (i == squadsList.size() - 1) {
                    squads.append(squadsList.get(i));
                } else {
                    squads.append(squadsList.get(i));
                    squads.append("，");
                }
            }
            selectCourse.setSquad(squads.toString());
            list.add(selectCourse);
        }
        return new JsonResult(0, "获取课程成功！", list);
    }

    @Override
    public JsonResult getAllClasses() {
        List<String> classes = studentDao.getAllClasses();
        return new JsonResult(0, "", classes);
    }

    @Override
    public JsonResult delCourse(String id) {
        Boolean flag1 = courseDao.delCourse(Integer.parseInt(id));
        if (flag1) {
            Boolean flag2 = dtoDao.delSelectCourse(Integer.parseInt(id));
            if (flag2) {
                return new JsonResult(0, "删除课程成功", null);
            } else {
                return new JsonResult(1, "删除课程失败", null);
            }
        } else {
            return new JsonResult(1, "删除课程失败", null);
        }
    }

    @Override
    public JsonResult updateCourse(HashMap<String, String> map) {
        String courseName = map.get("courseName");
        String imgUrl = map.get("imgUrl");
        String notice = map.get("notice");
        String intro = map.get("intro");
        String courseId = map.get("courseId");

        Course course = new Course();
        course.setId(Integer.parseInt(courseId));
        course.setCourseName(courseName);
        course.setImgUrl(imgUrl);
        course.setNotice(notice);
        course.setIntro(intro);

        Boolean flag1 = courseDao.updateCourse(course);

        if (flag1) {
            dtoDao.delSelectCourse(course.getId());
            String classes = map.get("classes");
            String[] squadList = classes.split(",");
            for (String squad : squadList) {
                dtoDao.createSelectCourse(course.getId(), squad);
            }
            return new JsonResult(0, "更新课程成功！", null);
        } else {
            return new JsonResult(1, "更新课程失败！", null);
        }
    }

    @Override
    public JsonResult delVideo(String courseId, String fileName) {
        File file = new File(filePath + '\\' + courseId + '\\' + "video" + '\\' + fileName);
        if (file.isFile() && file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                fileDao.delVideo(Integer.parseInt(courseId), fileName);
                return new JsonResult(0, "文件删除成功。", null);
            } else {
                return new JsonResult(1, "文件删除失败。", null);
            }
        }
        return new JsonResult(1, "文件删除失败。", null);
    }
}
