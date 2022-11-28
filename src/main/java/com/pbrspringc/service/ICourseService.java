package com.pbrspringc.service;

import com.pbrspringc.entity.Course;

import java.util.List;

public interface ICourseService {
    Course create(Course course);
    List<Course> list();
    Course getOne(String id);
    Course getOneByTitle(String title);
    Course delete(String id);
    Course updateCourse(Course course);
}
