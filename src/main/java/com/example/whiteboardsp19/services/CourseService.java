package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Lesson;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        Course cs5610 = new Course(123, "CS5610");
        Course cs4500 = new Course(234, "CS4500");
        Module cs4500W1 = new Module(123, "Week 1");
        Module cs4500W2 = new Module(234, "Week 2");
        Lesson ls1 = new Lesson(909, "Lesson 1");
        Lesson ls2 = new Lesson(808, "Lesson 2");
        List<Lesson> module1Lessons = new ArrayList<>();
        List<Module> cs4500Modules = new ArrayList<>();

        module1Lessons.add(ls1);
        module1Lessons.add(ls2);
        cs4500W1.setLessons(module1Lessons);
        cs4500Modules.add(cs4500W1);
        cs4500Modules.add(cs4500W2);
        cs4500.setModules(cs4500Modules);
        courses.add(cs4500);
        courses.add(cs5610);
    }

    public List<Course> deleteCourse(int courseId) {
        courses = courses.stream()
                .filter(course -> course.getId() != courseId)
                .collect(Collectors.toList());
        return courses;
    }


    public Course updateCourse(Integer id, Course newCourse) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                course.setTitle(newCourse.getTitle());
                return course;
            }
        }
        return null;
    }

    public List<Course> createCourse(Course course) {
        course.setId((int) (Math.random() * 10000));
        courses.add(course);
        return courses;
    }

    public List<Course> findAllCourses() {
        return courses;
    }

    public Course findCourseById(Integer id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

}