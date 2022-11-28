package com.pbrspringc;

import com.pbrspringc.config.BeanConfiguration;
import com.pbrspringc.entity.Course;
import com.pbrspringc.service.ICourseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ctx.register(BeanConfiguration.class);
        ctx.refresh();
        ICourseService courseService = (ICourseService) ctx.getBean(ICourseService.class);


        Course springCourse = new Course();
        springCourse.setCourseId("123");
        springCourse.setDescription("Spring IoC");
        springCourse.setTitle("Spring IoC Fundamental");

        ICourseService courseService1 = ctx.getBean(ICourseService.class);
        Course reactCourse = new Course();
        reactCourse.setCourseId("456");
        reactCourse.setDescription("React Redux State");
        reactCourse.setTitle("React Redux");

        courseService.create(springCourse);
        courseService.create(reactCourse);
        courseService.delete("456");
        courseService.list().forEach(course -> System.out.println(course));
//        Course courses = courseService.getOneByTitle("Spring IoC Fundamental");
//        System.out.println("=== FIND BY TITLE ===");
    }
}
