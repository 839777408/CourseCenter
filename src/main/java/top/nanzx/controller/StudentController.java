package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.StudentService;

import java.util.HashMap;

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

    @PostMapping("/login")
    public JsonResult login(@RequestBody HashMap<String, String> map) {
        return studentService.validateLogon(map);
    }

    @GetMapping("/getCourses")
    public JsonResult getCourses(@RequestParam("no") String no) {
        return studentService.getCourses(no);
    }
}
