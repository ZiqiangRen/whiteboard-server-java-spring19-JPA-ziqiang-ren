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

import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.repository.*;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.repository.LessonRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials="true")
public class LessonService {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  ModuleRepository moduleRepository;
  
  @PostMapping("/api/modules/{mid}/lesson")
  public List<Lesson> createLesson(@PathVariable("mid") Integer mId, @RequestBody Lesson lesson) {
	  Module module = moduleRepository.findById(mId).orElse(null);
	  lesson.setModule(module);
	  moduleRepository.save(module);
	  lessonRepository.save(lesson);
	  return module.getLessons();
  }
  
  @PutMapping("/api/lessons/{lessonId}")
  public Lesson updatelesson(@PathVariable("lessonId") int lId, @RequestBody Lesson newlesson) { // update
	  Lesson tmp = lessonRepository.findById(lId).orElse(null);
	  tmp.setTitle(newlesson.getTitle());
	  tmp.setTopics(newlesson.getTopics());
	  return lessonRepository.save(tmp);
  }  
  
  @GetMapping("/api/lessons/{lessonId}/module")
	public Module findParentModule(@PathVariable("lessonId") int lId) { // get parent
	  Lesson lesson = lessonRepository.findById(lId).orElse(null);
		return lesson.getModule();
	}
  
	@DeleteMapping("/api/lessons/{lessonId}")
	public void deleteLesson(@PathVariable("lessonId") int lId) { // delete
		lessonRepository.deleteById(lId);
	}
	
    @GetMapping("/api/modules/{mid}/lesson")
    public List<Lesson> findAllLessons(@PathVariable("mid") Integer mId) {
    	Module module = moduleRepository.findById(mId).orElse(null);
    	return module.getLessons();
    }
    
    @GetMapping("/api/lessons/{lessonId}")
    public Optional<Lesson> findlessonById(@PathVariable("lessonId") int lId) { // find one
        return lessonRepository.findById(lId);
    }    
  
  

  

}