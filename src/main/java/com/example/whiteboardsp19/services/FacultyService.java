package com.example.whiteboardsp19.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.*;
import com.example.whiteboardsp19.repository.FacultyRepository;
import com.example.whiteboardsp19.repository.CourseRepository;
import com.example.whiteboardsp19.repository.FacultyRepository;

@RestController
public class FacultyService {
  @Autowired
  FacultyRepository facultyRepository;
  @Autowired
  CourseRepository courseRepository;
  
  @GetMapping("/api/faculty")
  public List<Faculty> findAllFaculty() {
     return (List<Faculty>)facultyRepository.findAll();
  }
  @PutMapping("/api/faculty/{fId}/authored/{cId}")
  public void authoredCourse(
  		@PathVariable("fId") int fId,
  		@PathVariable("cId") int cId) {
  	Faculty faculty = facultyRepository.findById(fId).orElse(null);
  	Course course   = courseRepository.findById(cId).orElse(null);
  	course.setAuthor(faculty);
  	courseRepository.save(course);
  	//faculty.authoredCourse(course);
  	//facultyRepository.save(faculty);
  }
  
  @GetMapping("/api/faculty/{facultyId}/authored")
  	public Iterable<Course> findAuthoredCourses(
  			@PathVariable("facultyId") int fId) {
  		Faculty faculty = facultyRepository.findById(fId).orElse(null);
  		return faculty.getAuthoredCourses();
  }


  
}

