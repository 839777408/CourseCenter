package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.nanzx.dao.MeansDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Means;
import top.nanzx.service.TeacherService;

import java.io.File;

/**
 * @Author: Nan
 * @Date: Created in 13:26 2021/1/24
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private MeansDao meansDao;
    @Value("spring.multipartFile.path")
    private String filePath;

    /**
     * @Author: Nan
     * @Param: [file]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 23:05 2021/2/12
     * @Description: 文件上传
     */
    @Override
    public JsonResult upload(MultipartFile file, int courseId) {
        if (file == null || file.isEmpty()) {
            return new JsonResult(1, "未选择需上传的文件", null);
        }

        String originalFilename = file.getOriginalFilename();
        Means means = meansDao.queryFile(originalFilename, courseId);
        if (means != null) {
            return new JsonResult(1, "该课程下已有重复文件名！", null);
        }

        File dest = new File(filePath+originalFilename);
        if(!dest.getParentFile().exists()) {
            boolean mkdirs = dest.getParentFile().mkdirs();
            if (!mkdirs){
                return new JsonResult(1, "文件路径异常，请联系管理员。", null);
            }
        }
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(1, "文件上传失败。", null);
        }
        return new JsonResult(1, "文件上传成功！", null);
    }
}
