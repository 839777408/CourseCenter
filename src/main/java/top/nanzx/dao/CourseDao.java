package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Course;

/**
 * @Author: Nan
 * @Date: Created in 23:39 2021/1/28
 * @Description:
 */
@Mapper
public interface CourseDao {

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(column = "teacher_no",property = "teacher",one=@One(select = "top.nanzx.dao.TeacherDao.getTeacherInfoByNo"))
    })
    Course getCourseInfoById(String id);
}
