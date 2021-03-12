package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Means;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 23:51 2021/2/12
 * @Description:
 */
@Mapper
public interface MeansDao {

    @Select("SELECT * FROM means WHERE file_name = #{fileName} and course_id = #{courseId}")
    Means queryFile(@Param("fileName") String fileName, @Param("courseId") int courseId);

    @Select("SELECT id, file_name, course_id, upload_time, size FROM means WHERE course_id = #{courseId}")
    List<Means> queryFilesByCourseId(int courseId);

    @Insert("INSERT INTO means(file_name,course_id,upload_time,size) VALUES(#{means.fileName}," +
            "#{means.course.id},#{means.uploadTime},#{means.size})")
    Boolean addFile(@Param("means") Means means);

    @Delete("DELETE FROM means WHERE course_id = #{courseId} AND file_name = #{fileName}")
    Boolean delFile(@Param("courseId")int courseId, @Param("fileName")String fileName);
}


