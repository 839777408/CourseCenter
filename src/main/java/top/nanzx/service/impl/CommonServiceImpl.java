package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.CourseDao;
import top.nanzx.dao.DtoDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Course;
import top.nanzx.dto.ShowCourse;
import top.nanzx.service.CommonService;
import top.nanzx.service.StudentService;
import top.nanzx.service.TeacherService;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 22:17 2021/1/27
 * @Description:
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private DtoDao dtoDao;


    /**
     * @Author: Nan
     * @Param: [map]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:20 2021/1/27
     * @Description: 登录接口（用户身份判断）
     */
    @Override
    public JsonResult login(HashMap<String, String> map) {
        String type = map.get("type");
        String no = map.get("username");
        String password = map.get("password");
        if ("student".equals(type)) {
            return studentService.validateLogon(no, password);
        } else if ("teacher".equals(type)) {
            return teacherService.validateLogon(no, password);
        } else {
            return new JsonResult(1, "类型输入有误！", null);
        }
    }

    /**
     * @Author: Nan
     * @Param: [type]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 13:14 2021/1/30
     * @Description: 获取首页展示课程
     */
    @Override
    public JsonResult showCourse(String type) {
        List<ShowCourse> courses = dtoDao.showCourse(type);
        if (courses != null) {
            return new JsonResult(0, "首页展示课程获取成功！", courses);
        } else {
            return new JsonResult(1, "系统出错，首页展示课程获取失败！", null);
        }
    }

    /**
     * @Author: Nan
     * @Param: []
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 13:14 2021/1/30
     * @Description: 获取课程热度排行榜
     */
    @Override
    public JsonResult rankCourse() {
        List<Course> courses = courseDao.rankCourse();
        if (courses != null) {
            return new JsonResult(0, "首页课程排行榜获取成功！", courses);
        } else {
            return new JsonResult(1, "系统出错，首页课程排行榜获取失败！", null);
        }
    }
}
