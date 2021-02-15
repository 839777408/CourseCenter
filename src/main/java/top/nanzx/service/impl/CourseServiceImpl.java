package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.MeansDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Means;
import top.nanzx.service.CourseService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 16:05 2021/2/14
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private MeansDao meansDao;
//    @Value("spring.servlet.multipart.max-file-size")
//    private String size;

    /**
     * @Author: Nan
     * @Param: [courseId]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 15:54 2021/2/14
     * @Description: 获取课程资料列表
     */
    @Override
    public JsonResult getMainsList(int courseId) {
        List<Means> meansList = meansDao.queryFilesByCourseId(courseId);
        return new JsonResult(0, "获取课程资料列表成功！", meansList);
    }

    /**
     * @Author: Nan
     * @Param: [courseId, fileName, response]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 12:38 2021/2/14
     * @Description: 下载文件接口
     */
    @Override
    public JsonResult download(int courseId, String fileName, HttpServletResponse response) {
        Means means = meansDao.queryFile(fileName, courseId);
        File file = new File(means.getFilePath() +'\\'+ means.getFileName());
        System.out.println(file.length());

        if (!file.exists()) {
            return new JsonResult(1, "文件不存在！", null);
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" +  new String(fileName.getBytes(StandardCharsets.UTF_8), Charset.forName("ISO8859-1")));

        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, "文件下载失败。", null);
        }
        return null;
    }
}
