package top.nanzx.dao;

import org.apache.ibatis.annotations.*;
import top.nanzx.entity.Note;

import java.util.Date;
import java.util.List;

/**
 * @Author: Nan
 * @Date: Created in 22:43 2021/2/4
 * @Description:
 */
@Mapper
public interface NoteDao {
    @Select("SELECT * FROM note WHERE no = #{no} ORDER BY create_Time DESC")
    List<Note> getNotes(@Param("no") String no);

    @Insert("INSERT INTO note(title,content,create_time,no) VALUES (#{title},#{content},#{date},#{no})")
    Boolean addNote(@Param("no") String no, @Param("title") String title, @Param("content") String content, @Param("date") Date date);

    @Select("SELECT * FROM note WHERE id = #{id}")
    Note getNote(String id);

    @Update("UPDATE note SET title = #{title}, content = #{content}, create_time = #{date} WHERE id = #{id}")
    Boolean editNote(@Param("id") String id, @Param("title") String title, @Param("content") String content, @Param("date") Date date);

    @Delete("DELETE FROM note WHERE id = #{id}")
    Boolean delNote(String id);
}
