package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Course;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 23:39 2021/1/28
 * @Description:
 */
@Mapper
public interface CourseDao {

    @Select("SELECT id, course_name, activity FROM course ORDER BY activity DESC LIMIT 10")
    List<Course> rankCourse();

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(column = "teacher_no", property = "teacher", one = @One(select = "top.nanzx.dao.TeacherDao.getTeacherInfoByNo"))
    })
    Course getCourseInfoById(String id);

    @Select("SELECT * FROM course WHERE teacher_no = #{no} ORDER BY create_time DESC")
    @Results({
            @Result(column = "teacher_no", property = "teacher", one = @One(select = "top.nanzx.dao.TeacherDao.getTeacherInfoByNo"))
    })
    List<Course> getCoursesByTeacherNo(String no);

    @Insert("INSERT INTO course(course_name,img_url,teacher_no,create_time,intro,activity,notice) " +
            "VALUES (#{course.courseName},#{course.imgUrl},#{course.teacher.no},#{course.createTime}," +
            "#{course.intro},#{course.activity},#{course.notice})")
    @Options(useGeneratedKeys = true, keyProperty = "course.id", keyColumn = "id")
    Boolean createCourse(@Param("course") Course course);
}
