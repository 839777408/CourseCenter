package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Course;
import top.nanzx.entity.ShowCourse;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 22:19 2021/1/27
 * @Description:
 */
@Mapper
public interface CommonDao {

    @Select("SELECT * FROM show_course WHERE type = #{type}")
    @Results({@Result(column = "type", property = "type"),
            @Result(column = "course_id", property = "course", one = @One(select = "top.nanzx.dao.CourseDao.getCourseInfoById"))})
    List<ShowCourse> showCourse(String type);

    @Select("SELECT id, course_name, activity FROM course ORDER BY activity DESC LIMIT 10")
    List<Course> rankCourse();
}
