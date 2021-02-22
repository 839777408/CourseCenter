package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.StudentService;

/**
 * @Author: Nan
 * @Date: Created in 21:52 2021/2/17
 * @Description:
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getCourses")
    public JsonResult getCourses(@RequestParam("no") String no) {
        return studentService.getCourses(no);
    }
}
