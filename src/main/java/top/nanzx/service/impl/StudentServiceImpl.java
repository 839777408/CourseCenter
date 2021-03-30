package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.DtoDao;
import top.nanzx.dao.StudentDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.dto.SelectCourse;
import top.nanzx.entity.Student;
import top.nanzx.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Nan
 * @Date: Created in 21:13 2021/1/23
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DtoDao dtoDao;

    /**
     * @Author: Nan
     * @Param: [no, password]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 23:09 2021/1/30
     * @Description: 学生登录验证
     */
    @Override
    public JsonResult validateLogon(HashMap<String, String> map) {
        String no = map.get("username");
        String password = map.get("password");
        Student student = studentDao.validateLogon(no, password);
        if (student == null) {
            return new JsonResult(1, "登录失败，请检查学号和密码是否输入有误！", null);
        } else {
            ConcurrentHashMap<String, String> returnMap = new ConcurrentHashMap<>();
            returnMap.put("no", student.getNo());
            returnMap.put("name", student.getName());
            returnMap.put("squad", student.getSquad());
            return new JsonResult(0, "登录成功！", returnMap);
        }
    }

    /**
     * @Author: Nan
     * @Param: [no]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:17 2021/2/17
     * @Description: 获取该学生的所有课程
     */
    @Override
    public JsonResult getCourses(String no) {
        String squad = studentDao.getSquad(no);
        List<SelectCourse> courseList = dtoDao.getCoursesBySquad(squad);
        if (courseList != null) {
            return new JsonResult(0, "查询成功！", courseList);
        } else {
            return new JsonResult(1, "暂时没有课程！", null);
        }
    }
}
