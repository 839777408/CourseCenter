package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.CourseService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Nan
 * @Date: Created in 16:03 2021/2/14
 * @Description:
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getMainsList/{courseId}")
    public JsonResult getMainsList(@PathVariable("courseId") int courseId){
        return courseService.getMainsList(courseId);
    }

    @GetMapping(value = "/download/{courseId}/{fileName}")
    public JsonResult download(@PathVariable("courseId") int courseId, @PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        return courseService.download(courseId, fileName, response);
    }
}
