package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dao.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Course;
import top.nanzx.entity.Means;
import top.nanzx.entity.Teacher;
import top.nanzx.service.TeacherService;

import java.io.File;
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
    private MeansDao meansDao;
    @Value("spring.multipartFile.path")
    private String filePath;


    /**
     * @Author: Nan
     * @Param: [no, password]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 15:18 2021/2/15
     * @Description: 老师登录验证
     */
    @Override
    public JsonResult validateLogon(String no, String password) {
        Teacher teacher = teacherDao.validateLogon(no, password);
        if (teacher == null) {
            return new JsonResult(1, "登录失败，请检查工号和密码是否输入有误！", null);
        } else {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
            map.put("no", teacher.getNo());
            map.put("name", teacher.getName());
            map.put("squad", "");
            return new JsonResult(0, "登录成功！", map);
        }
    }

    /**
     * @Author: Nan
     * @Param: [map]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 20:57 2021/2/22
     * @Description: 创建课程，未进行事务管理
     */
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

    /**
     * @Author: Nan
     * @Param: [file]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 23:05 2021/2/12
     * @Description: 文件上传
     */
    @Override
    public JsonResult upload(MultipartFile file, int courseId) {
        if (file == null || file.isEmpty()) {
            return new JsonResult(1, "未选择需上传的文件", null);
        }

        String originalFilename = file.getOriginalFilename();
        Means means = meansDao.queryFile(originalFilename, courseId);
        if (means != null) {
            return new JsonResult(1, "该课程下已有重复文件名！", null);
        }

        File dest = new File(filePath + originalFilename);
        if (!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
            if (!mkdirs) {
                return new JsonResult(1, "文件路径异常，请联系管理员。", null);
            }
        }
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "文件上传失败。", null);
        }
        return new JsonResult(0, "文件上传成功！", null);
    }

    /**
     * @Author: Nan
     * @Param: [no]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 9:46 2021/2/16
     * @Description: 获取该老师管理的所有课程
     */
    @Override
    public JsonResult getCourses(String no) {
        List<Course> courses = courseDao.getCoursesByTeacherNo(no);
        return new JsonResult(0, "", courses);
    }

    /**
     * @Author: Nan
     * @Param: []
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:05 2021/2/19
     * @Description: 获取学校的所有班级
     */
    @Override
    public JsonResult getAllClasses() {
        List<String> classes = studentDao.getAllClasses();
        return new JsonResult(0, "", classes);
    }
}
