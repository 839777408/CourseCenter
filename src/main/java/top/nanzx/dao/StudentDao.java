package top.nanzx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.nanzx.entity.Student;

/**
 * @Author: Nan
 * @Date: Created in 21:12 2021/1/23
 * @Description:
 */
@Mapper
public interface StudentDao {

    /**
     * @Author: Nan
     * @Param: [no, password]
     * @Return: top.nanzx.entity.Student
     * @Date: 13:56 2021/1/24
     * @Description: 登录验证
     */
    @Select("SELECT * FROM student WHERE no = #{no} AND password = #{password}")
    Student validateLogon(@Param("no") String no, @Param("password") String password);
}
