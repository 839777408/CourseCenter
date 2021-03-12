package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.nanzx.dao.CourseDao;
import top.nanzx.dao.DtoDao;
import top.nanzx.dao.MeansDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.dto.SelectCourse;
import top.nanzx.entity.Course;
import top.nanzx.entity.Means;
import top.nanzx.service.CourseService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 16:05 2021/2/14
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private MeansDao meansDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private DtoDao dtoDao;
    //    @Value("spring.servlet.multipart.max-file-size")
//    private String size;
    @Value("${multipartFile.path}")
    private String filePath;

    /**
     * @Author: Nan
     * @Param: [courseId]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 15:39 2021/2/27
     * @Description: 获取课程简介
     */
    @Override
    public JsonResult getCourseInfo(int courseId) {
        Course course = courseDao.getCourseInfoById(courseId);

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
        return new JsonResult(0, "获取课程简介成功！", selectCourse);
    }

    /**
     * @Author: Nan
     * @Param: [courseId]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 15:54 2021/2/14
     * @Description: 获取课程资料列表
     */
    @Override
    public JsonResult getMainsList(int courseId) {
        List<Means> meansList = meansDao.queryFilesByCourseId(courseId);
        return new JsonResult(0, "获取课程资料列表成功！", meansList);
    }

    /**
     * @Author: Nan
     * @Param: [courseId, fileName, response]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 12:38 2021/2/14
     * @Description: 下载文件接口
     */
    @Override
    public JsonResult download(int courseId, String fileName, HttpServletResponse response) {
        Means means = meansDao.queryFile(fileName, courseId);
        File file = new File(filePath + '\\' +courseId + '\\' + means.getFileName());

        if (!file.exists()) {
            return new JsonResult(1, "文件不存在！", null);
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes(StandardCharsets.UTF_8), Charset.forName("ISO8859-1")));

        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "文件下载失败。", null);
        }
        return null;
    }
}
