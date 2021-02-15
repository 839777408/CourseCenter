package top.nanzx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.nanzx.dao.CommonDao;
import top.nanzx.entity.Course;
import top.nanzx.entity.ShowCourse;

import java.util.List;

@SpringBootTest
class CourseCenterApplicationTests {

    @Autowired
    private CommonDao commonDao;

    @Test
    void contextLoads1() {
        List<ShowCourse> showCourses = commonDao.showCourse("new");
        System.out.println(showCourses);
    }

    @Test
    void contextLoads2() {
        List<Course> courses = commonDao.rankCourse();
        System.out.println(courses);
    }

}
