package com.example.whiteboardsp19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.services.CourseService;


@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping("/api/courses/{id}")
    public List<Course> deleteCourse(@PathVariable("id") int courseId) {
        return courseService.deleteCourse(courseId);
    }


    @PutMapping("/api/courses/{courseId}")
    public Course updateCourse(@PathVariable("courseId") Integer id, @RequestBody Course newCourse) {
        return courseService.updateCourse(id, newCourse);
    }

    @PostMapping("/api/courses")
    public List<Course> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Integer id) {
        return courseService.findCourseById(id);
    }

}