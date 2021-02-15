package top.nanzx.service;

import top.nanzx.dto.JsonResult;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 22:17 2021/1/27
 * @Description:
 */
public interface CommonService {

    JsonResult login(HashMap<String, String> map);

    JsonResult showCourse(String type);

    JsonResult rankCourse();
}
