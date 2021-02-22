package top.nanzx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nanzx.entity.Course;

/**
 * @Author: Nan
 * @Date: Created in 23:12 2021/2/17
 * @Description: 封装学生所学的所有课程
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectCourse {

    private Course course;

    private String squad;
}
