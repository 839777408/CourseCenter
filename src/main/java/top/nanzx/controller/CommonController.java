package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.CommonService;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 21:55 2021/1/23
 * @Description:
 */
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/login")
    public JsonResult login(@RequestBody HashMap<String, String> map) {
        return commonService.login(map);
    }

    @GetMapping("/showCourse")
    public JsonResult showCourse(@RequestParam String type) {
        return commonService.showCourse(type);
    }

    @GetMapping("/rankCourse")
    public JsonResult rankCourse() {
        return commonService.rankCourse();
    }
}
