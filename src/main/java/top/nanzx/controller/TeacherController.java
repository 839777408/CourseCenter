package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.TeacherService;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 22:57 2021/2/12
 * @Description:
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/createCourse")
    public JsonResult createCourse(@RequestBody HashMap<String, String> map) {
        return teacherService.createCourse(map);
    }

    @PostMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file, @RequestParam("courseId") int courseId) {
        return teacherService.upload(file, courseId);
    }

    @DeleteMapping("/delMain")
    public JsonResult delMain(@RequestParam("courseId") String courseId, @RequestParam("fileName") String fileName) {
        return teacherService.delMain(courseId, fileName);
    }

    @GetMapping("/getCourses")
    public JsonResult getCourses(@RequestParam("no") String no) {
        return teacherService.getCourses(no);
    }

    @GetMapping("/getAllClasses")
    public JsonResult getAllClasses() {
        return teacherService.getAllClasses();
    }

    @DeleteMapping("/delCourse/{id}")
    public JsonResult delCourse(@PathVariable("id") String id) {
        return teacherService.delCourse(id);
    }

    @PostMapping("/updateCourse")
    public JsonResult updateCourse(@RequestBody HashMap<String, String> map) {
        return teacherService.updateCourse(map);
    }
}
