package top.nanzx.service;

import top.nanzx.dto.JsonResult;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 21:13 2021/1/23
 * @Description:
 */
public interface StudentService {

    JsonResult validateLogon(HashMap<String, String> map);

    JsonResult getCourses(String no);
}
