package top.nanzx.service;

import top.nanzx.dto.JsonResult;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Nan
 * @Date: Created in 16:04 2021/2/14
 * @Description:
 */
public interface CourseService {

    JsonResult getCourseInfo(int courseId);

    JsonResult getMainsList(int courseId);

    JsonResult download(int courseId, String fileName, HttpServletResponse response) throws Exception;
}
