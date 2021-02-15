package top.nanzx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Nan
 * @Date: Created in 22:47 2021/1/27
 * @Description: 封装首页展示的课程
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowCourse {

    private Course course;

    private String type;//推荐、热门、最新
}
