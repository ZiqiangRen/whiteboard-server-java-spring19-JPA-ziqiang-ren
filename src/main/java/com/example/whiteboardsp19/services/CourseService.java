package com.example.whiteboardsp19.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Faculty;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.repository.CourseRepository;

@RestController
public class CourseService {
  @Autowired
  CourseRepository courseRepository;
  
  @PostMapping("/api/courses")
  public Course createCourse(@RequestBody Course course) { //create
     return courseRepository.save(course);
  }
  
  @PutMapping("/api/courses/{courseId}")
  public Course updateCourse(@PathVariable("courseId") int cId, @RequestBody Course newCourse) { // update
	  Course tmp = courseRepository.findById(cId).orElse(null);
	  tmp.setTitle(newCourse.getTitle());
	  tmp.setModules(newCourse.getModules());
	  return courseRepository.save(tmp);
  }  
  
  @GetMapping("/api/courses/{courseId}/author")
	public Faculty findCourseAuthor(@PathVariable("courseId") int cId) { // get parent
		Course course = courseRepository.findById(cId).orElse(null);
		return course.getAuthor();
	}
  
	@DeleteMapping("/api/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") int cId) { // delete
		courseRepository.deleteById(cId);
	}
	
    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {  // find all
        return (List<Course>) courseRepository.findAll();
    }
    
    @GetMapping("/api/courses/{courseId}")
    public Optional<Course> findCourseById(@PathVariable("courseId") int cId) { // find one
        return courseRepository.findById(cId);
    }    
  
  

  

}