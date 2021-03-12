package top.nanzx.service;

import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dto.JsonResult;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 13:26 2021/1/24
 * @Description:
 */
public interface TeacherService {

    JsonResult createCourse(HashMap<String, String> map);

    JsonResult validateLogon(String no, String password);

    JsonResult upload(MultipartFile file, int courseId);

    JsonResult delMain(String courseId, String fileName);

    JsonResult getCourses(String no);

    JsonResult getAllClasses();

    JsonResult delCourse(String id);

    JsonResult updateCourse(HashMap<String, String> map);
}
