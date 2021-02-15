package top.nanzx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.nanzx.entity.Teacher;

/**
 * @Author: Nan
 * @Date: Created in 20:41 2021/1/29
 * @Description:
 */
@Mapper
public interface TeacherDao {

    @Select("SELECT name, department FROM teacher WHERE no = #{no}")
    Teacher getTeacherInfoByNo(String no);


}
