package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.dto.SelectCourse;
import top.nanzx.dto.ShowCourse;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 22:39 2021/2/17
 * @Description:
 */
@Mapper
public interface DtoDao {

    @Select("SELECT * FROM show_course WHERE type = #{type}")
    @Results({@Result(column = "type", property = "type"),
            @Result(column = "course_id", property = "course", one = @One(select = "top.nanzx.dao.CourseDao.getCourseInfoById"))})
    List<ShowCourse> showCourse(String type);

    @Select("SELECT * FROM select_course WHERE squad = #{squad}")
    @Results({
            @Result(column = "course_id", property = "course", one = @One(select = "top.nanzx.dao.CourseDao.getCourseInfoById"))
    })
    List<SelectCourse> getCoursesBySquad(String squad);

    @Insert("INSERT INTO select_course(course_id, squad) VALUES (#{courseId},#{squad})")
    Boolean createSelectCourse(@Param("courseId") int courseId, @Param("squad") String squad);
}
