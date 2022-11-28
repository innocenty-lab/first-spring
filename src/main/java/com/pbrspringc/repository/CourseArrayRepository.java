package com.pbrspringc.repository;

import com.pbrspringc.entity.Course;
import com.pbrspringc.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class CourseArrayRepository implements ICourseRepository {
    private List<Course> courseList = new ArrayList<>();

    @Autowired
    @Qualifier("int")
    IRandomStringGenerator randomID;

    @Override
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public Course create(Course course) {
        course.setCourseId(randomID.random());
        courseList.add(course);
        return course;
    }

    @Override
    public Course findOne(String id) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getCourseId().equals(id)) {
                course = c;
            }
        }
        return course;
    }

    @Override
    public Course update(Course course) {
        int i = 0;
        for (Course c : courseList) {
            i++;
            if (c.getCourseId().equals(course.getCourseId())) {
                courseList.set(i - 1, course);
            }
        }
        return null;
    }

    @Override
    public Course delete(String id) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getCourseId().equals(id)) {
                courseList.remove(c);
                break;
            }
        }
        return course;
    }

    @Override
    public Course findByTitle(String title) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getTitle().equals(title)) {
                course = c;
            }
        }
        return course;
    }
}
