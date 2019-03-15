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

import com.example.whiteboardsp19.model.Topic;
import com.example.whiteboardsp19.repository.*;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.model.*;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Widget;

public class HeadingWidgetService {
	  @Autowired
	  TopicRepository topicRepository;
	  @Autowired
	  HeadingWidgetRepository headingWidgetRepository;
	
	  @PutMapping("/api/heading/widgets/{wId}")
	  public HeadingWidget updateHeadingWidget(@PathVariable("wId") int wId, @RequestBody HeadingWidget newwidget) { // update
		  HeadingWidget tmp = headingWidgetRepository.findById(wId).orElse(null);
		  //tmp.setTopic(newwidget.getTopic());
		  tmp.setHeight(newwidget.getHeight());
		  tmp.setWidth(newwidget.getWidth());
		  tmp.setTitle(newwidget.getTitle());
		  tmp.setSize(newwidget.getSize());
		  return headingWidgetRepository.save(tmp);
	  }  
	
	    @GetMapping("/api/heading/widgets/{wId}")
	    public Optional<HeadingWidget> findHeadingWidgetById(@PathVariable("wId") int wId) { // find one
	        return headingWidgetRepository.findById(wId);
	    } 
	    
		@DeleteMapping("/api/heading/widgets/{wId}")
		public void deleteHeadingWidget(@PathVariable("wId") int wId) { // delete
			headingWidgetRepository.deleteById(wId);
		}
	    

}
