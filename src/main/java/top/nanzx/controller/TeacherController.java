package top.nanzx.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dto.JsonResult;

/**
 * @Author: Nan
 * @Date: Created in 22:57 2021/2/12
 * @Description:
 */
@RestController
public class TeacherController {

    @PostMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file,@RequestParam("courseId") int courseId) {
        return null;
    }

}
