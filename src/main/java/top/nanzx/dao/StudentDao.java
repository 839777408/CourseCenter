package top.nanzx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.nanzx.entity.Student;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 21:12 2021/1/23
 * @Description:
 */
@Mapper
public interface StudentDao {

    @Select("SELECT * FROM student WHERE no = #{no} AND password = #{password}")
    Student validateLogon(@Param("no") String no, @Param("password") String password);

    @Select("SELECT squad FROM student WHERE no = #{no}")
    String getSquad(@Param("no") String no);

    @Select("SELECT squad FROM student GROUP BY squad ORDER BY squad ASC")
    List<String> getAllClasses();
}
