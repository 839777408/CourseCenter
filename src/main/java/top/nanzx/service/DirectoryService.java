package top.nanzx.service;

import top.nanzx.dto.JsonResult;

import java.util.HashMap;

/**
 * @Author: Nan
 * @Date: Created in 15:00 2021/3/14
 * @Description:
 */
public interface DirectoryService {

    JsonResult getUnits(int courseId);

    JsonResult addUnits(int courseId, HashMap<String, Object> map);

    JsonResult getPeriods(int courseId, int unitId);

    JsonResult addPeriods(int courseId, HashMap<String, Object> map);

    JsonResult getDirectory(int courseId);
}
