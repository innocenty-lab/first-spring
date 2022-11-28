package com.pbrspringc;

import com.pbrspringc.container.ConsoleRunner;
import com.pbrspringc.entity.Course;
import com.pbrspringc.service.ICourseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleApp implements ConsoleRunner {
    private final ICourseService iCourseService;

    public ConsoleApp(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @Override
    public void run(String... args) {
        System.out.println("Course Service 1 Object Id");
//        System.out.println(courseService);
        Course springCourse = new Course();
        springCourse.setCourseId("123");
        springCourse.setDescription("Spring IoC");
        springCourse.setTitle("Spring IoC Fundamental");
        iCourseService.create(springCourse);

        System.out.println("Course Service 2 Object Id");
//        System.out.println(courseService);
        Course reactCourse = new Course();
        reactCourse.setCourseId("456");
        reactCourse.setDescription("React Redux State");
        reactCourse.setTitle("React Redux");
        iCourseService.create(reactCourse);

        List<Course> courseList1 = iCourseService.list();
        System.out.println(courseList1);

        List<Course> courseList2 = iCourseService.list();
        System.out.println(courseList2);

//        iCourseService.list().forEach(course -> System.out.println(course));
    }
}
