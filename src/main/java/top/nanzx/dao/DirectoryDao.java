package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Period;
import top.nanzx.entity.Unit;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 15:02 2021/3/14
 * @Description:
 */
@Mapper
public interface DirectoryDao {

    @Select("SELECT * FROM unit WHERE course_id = #{courseId}")
    List<Unit> getUnits(@Param("courseId") int courseId);

    @Delete("DELETE FROM unit WHERE course_id = #{courseId}")
    Boolean delUnits(@Param("courseId") int courseId);

    @Insert("INSERT INTO unit(course_id, unit_id, unit_name ) VALUES(#{courseId},#{unitId},#{unitName})")
    Boolean addUnit(@Param("courseId") int courseId, @Param("unitId") int unitId, @Param("unitName") String unitName);

    @Select("SELECT * FROM period WHERE course_id = #{courseId} AND unit_id = #{unitId}")
    List<Period> getPeriods(@Param("courseId") int courseId, @Param("unitId") int unitId);

    @Delete("DELETE FROM period WHERE course_id = #{courseId} AND unit_id = #{unitId}")
    Boolean delPeriods(@Param("courseId") int courseId, @Param("unitId") int unitId);

    @Insert("INSERT INTO period(course_id,unit_id,period_id,period_name) VALUES(#{courseId},#{unitId},#{periodId},#{periodName})")
    Boolean addPeriod(@Param("courseId") int courseId, @Param("unitId") int unitId, @Param("periodId") int periodId, @Param("periodName") String periodName);
}
