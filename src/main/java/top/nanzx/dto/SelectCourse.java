package top.nanzx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.nanzx.entity.Course;

/**
 * @Author: Nan
 * @Date: Created in 23:12 2021/2/17
 * @Description: 封装班级和所修课程，多对多。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectCourse {

    private Course course;

    private String squad;
}
