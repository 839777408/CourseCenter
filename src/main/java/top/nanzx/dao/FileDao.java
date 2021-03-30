package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Means;
import top.nanzx.entity.Video;

import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 23:51 2021/2/12
 * @Description:
 */
@Mapper
public interface FileDao {

    @Select("SELECT * FROM means WHERE file_name = #{fileName} and course_id = #{courseId}")
    Means queryMean(@Param("fileName") String fileName, @Param("courseId") int courseId);

    @Select("SELECT id, file_name, course_id, upload_time, size FROM means WHERE course_id = #{courseId}")
    List<Means> queryMeansByCourseId(int courseId);

    @Insert("INSERT INTO means(file_name,course_id,upload_time,size) VALUES(#{means.fileName}," +
            "#{means.course.id},#{means.uploadTime},#{means.size})")
    Boolean addMean(@Param("means") Means means);

    @Delete("DELETE FROM means WHERE course_id = #{courseId} AND file_name = #{fileName}")
    Boolean delMean(@Param("courseId")int courseId, @Param("fileName")String fileName);

    @Select("SELECT * FROM video WHERE file_name = #{fileName} and course_id = #{courseId}")
    Video queryVideo(@Param("fileName") String fileName, @Param("courseId") int courseId);

    @Insert("INSERT INTO video(file_name,course_id,upload_time,size) VALUES(#{video.fileName}," +
            "#{video.course.id},#{video.uploadTime},#{video.size})")
    Boolean addVideo(@Param("video") Video video);

    @Select("SELECT id, file_name, course_id, upload_time, size FROM video WHERE course_id = #{courseId}")
    List<Video> queryVideosByCourseId(int courseId);

    @Delete("DELETE FROM video WHERE course_id = #{courseId} AND file_name = #{fileName}")
    Boolean delVideo(@Param("courseId")int courseId, @Param("fileName")String fileName);
}


