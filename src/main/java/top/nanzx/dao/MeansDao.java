package top.nanzx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("SELECT id, file_name, course_id, upload_time FROM means WHERE course_id = #{courseId}")
    List<Means> queryFilesByCourseId(int courseId);
}
