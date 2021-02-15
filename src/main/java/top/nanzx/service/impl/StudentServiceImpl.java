package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.StudentDao;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Student;
import top.nanzx.service.StudentService;

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

    /**
     * @Author: Nan
     * @Param: [no, password]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 23:09 2021/1/30
     * @Description: 学生登录验证
     */
    @Override
    public JsonResult validateLogon(String no, String password) {
        Student student = studentDao.validateLogon(no, password);
        if (student == null){
            return new JsonResult(1,"登录失败，请检查学号和密码是否输入有误！",null);
        }else {
            ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
            map.put("no",student.getNo());
            map.put("name",student.getName());
            map.put("squad",student.getSquad());
            return new JsonResult(0,"登录成功！",map);
        }
    }
}
