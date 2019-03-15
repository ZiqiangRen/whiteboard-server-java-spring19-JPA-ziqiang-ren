package com.example.whiteboardsp19.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Topic;
import com.example.whiteboardsp19.repository.CourseRepository;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.repository.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials="true")
public class ModuleService {
  @Autowired
  ModuleRepository moduleRepository;
  @Autowired
  CourseRepository courseRepository;
  
  @PostMapping("/api/courses/{cid}/modules")
  public List<Module> createModule(@PathVariable("cid") Integer cId, @RequestBody Module module) {
	  Course course = courseRepository.findById(cId).orElse(null);
	  module.setCourse(course);
	  courseRepository.save(course);
	  moduleRepository.save(module);
	  return course.getModules();
  }
  
  @PutMapping("/api/modules/{moduleId}")
  public Module updatemodule(@PathVariable("moduleId") int mId, @RequestBody Module newmodule) { // update
	  Module tmp = moduleRepository.findById(mId).orElse(null);
	  tmp.setTitle(newmodule.getTitle());
	  tmp.setLessons(newmodule.getLessons());
	  return moduleRepository.save(tmp);
  }  
  
  @GetMapping("/api/modules/{moduleId}/course")
	public Course findParentCourse(@PathVariable("moduleId") int mId) { // get parent
	  Module module = moduleRepository.findById(mId).orElse(null);
		return module.getCourse();
	}
  
	@DeleteMapping("/api/modules/{moduleId}")
	public void deleteModule(@PathVariable("moduleId") int mId) { // delete
		moduleRepository.deleteById(mId);
	}
	
    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModules(@PathVariable("cid") Integer cId) {
    	Course course = courseRepository.findById(cId).orElse(null);
    	return course.getModules();
    }
    
    @GetMapping("/api/modules/{moduleId}")
    public Optional<Module> findmoduleById(@PathVariable("moduleId") int mId) { // find one
        return moduleRepository.findById(mId);
    }    
  
  

  

}