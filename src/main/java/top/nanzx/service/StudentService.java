package top.nanzx.service;

import top.nanzx.dto.JsonResult;

/**
 * @Author: Nan
 * @Date: Created in 21:13 2021/1/23
 * @Description:
 */
public interface StudentService {

    JsonResult validateLogon(String no, String password);
}
