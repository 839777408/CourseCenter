package top.nanzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.nanzx.dto.JsonResult;
import top.nanzx.service.DirectoryService;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 14:57 2021/3/14
 * @Description:
 */
@RestController
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @GetMapping("/getUnits")
    public JsonResult getUnits(@RequestParam("courseId") int courseId) {
        return directoryService.getUnits(courseId);
    }

    @PostMapping("/addUnits/{courseId}")
    public JsonResult addUnits(@PathVariable("courseId") int courseId, @RequestBody HashMap<String, Object> map) {
        return directoryService.addUnits(courseId, map);
    }

    @GetMapping("/getPeriods")
    public JsonResult getPeriods(@RequestParam("courseId") int courseId, @RequestParam("unitId") int unitId) {
        return directoryService.getPeriods(courseId, unitId);
    }

    @PostMapping("/addPeriods/{courseId}")
    public JsonResult addPeriods(@PathVariable("courseId") int courseId, @RequestBody HashMap<String, Object> map) {
        return directoryService.addPeriods(courseId, map);
    }

    @GetMapping("/getDirectory/{courseId}")
    public JsonResult getDirectory(@PathVariable("courseId") int courseId){
        return directoryService.getDirectory(courseId);
    }
}
