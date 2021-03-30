package top.nanzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.nanzx.dao.DirectoryDao;
import top.nanzx.dto.Directory;
import top.nanzx.dto.JsonResult;
import top.nanzx.entity.Period;
import top.nanzx.entity.Unit;
import top.nanzx.service.DirectoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 15:01 2021/3/14
 * @Description:
 */
@Service
public class DirectoryServiceImpl implements DirectoryService {

    @Autowired
    private DirectoryDao directoryDao;

    /**
     * @Author: Nan
     * @Param: [courseId]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 15:02 2021/3/14
     * @Description: 获取课程章节目录
     */
    @Override
    public JsonResult getUnits(int courseId) {
        List<Unit> units = directoryDao.getUnits(courseId);
        return new JsonResult(0, "获取章节目录成功", units);
    }

    /**
     * @Author: Nan
     * @Param: [courseId, map]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 18:18 2021/3/14
     * @Description: 保存章节目录
     */
    @Override
    public JsonResult addUnits(int courseId, HashMap<String, Object> map) {
//        System.out.println(map);
        Object unitsList = map.get("unitsList");
        String[] split = unitsList.toString().split(",");

        List<String> list = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split("=");
            if (split1[1].contains("}")) {
                String[] split2 = split1[1].split("}");
                list.add(split2[0]);
            } else {
                list.add(split1[1]);
            }
        }
//        System.out.println(list);
        directoryDao.delUnits(courseId);

        for (int i = 0; i < list.size(); i++) {
            directoryDao.addUnit(courseId, Integer.parseInt(list.get(i)), list.get(++i));
        }

        return new JsonResult(0, "保存成功!", null);
    }

    /**
     * @Author: Nan
     * @Param: [courseId, unitId]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 22:49 2021/3/18
     * @Description:获取课程该章节下的所有课时
     */
    @Override
    public JsonResult getPeriods(int courseId, int unitId) {
        List<Period> periods = directoryDao.getPeriods(courseId, unitId);
        return new JsonResult(0, "获取课时目录成功", periods);
    }

    /**
     * @Author: Nan
     * @Param: [courseId, map]
     * @Return: top.nanzx.dto.JsonResult
     * @Date: 1:59 2021/3/20
     * @Description:添加保存课时目录
     */
    @Override
    public JsonResult addPeriods(int courseId, HashMap<String, Object> map) {
        System.out.println(map);
        Object periodsList = map.get("periodsList");
        String[] split = periodsList.toString().split(",");

        List<String> list = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split("=");
            if (split1[1].contains("}")) {
                String[] split2 = split1[1].split("}");
                list.add(split2[0]);
            } else {
                list.add(split1[1]);
            }
        }
//        System.out.println(list);
        int unitId = Integer.parseInt(map.get("unitId").toString());
        directoryDao.delPeriods(courseId, unitId);

        for (int i = 0; i < list.size(); i++) {
            directoryDao.addPeriod(courseId, unitId, Integer.parseInt(list.get(i)), list.get(++i));
        }
        return new JsonResult(0, "保存成功!", null);
    }

    @Override
    public JsonResult getDirectory(int courseId) {
        List<Directory> directoryList = new ArrayList<>();

        List<Unit> units = directoryDao.getUnits(courseId);
        for (Unit u : units) {
            Directory directory = new Directory();
            directory.setLabel("第" + u.getUnitId() + "章  " + u.getUnitName());

            List<Period> periods = directoryDao.getPeriods(courseId, u.getUnitId());
            List<Object> children = new ArrayList<>();
            for (Period p : periods) {
                HashMap<String, String> map = new HashMap<>();
                map.put("label", p.getUnitId() + "." + p.getPeriodId() + "  " + p.getPeriodName());
                children.add(map);
            }
            directory.setChildren(children);
            directoryList.add(directory);
        }
        return new JsonResult(0, "保存成功!", directoryList);
    }
}
