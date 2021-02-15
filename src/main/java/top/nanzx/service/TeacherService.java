package top.nanzx.service;

import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dto.JsonResult;

/**
 * @Author: Nan
 * @Date: Created in 13:26 2021/1/24
 * @Description:
 */
public interface TeacherService {

    JsonResult upload(MultipartFile file,int courseId);
}
