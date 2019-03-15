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

import com.example.whiteboardsp19.model.Topic;
import com.example.whiteboardsp19.repository.*;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Widget;
@RestController
public class WidgetService {
	  @Autowired
	  TopicRepository topicRepository;
	  @Autowired
	  WidgetRepository widgetRepository;
	
	  @PutMapping("/api/widgets/{wId}")
	  public Widget updateWidget(@PathVariable("wId") int wId, @RequestBody Widget newwidget) { // update
		  Widget tmp = widgetRepository.findById(wId).orElse(null);
		  //tmp.setTopic(newwidget.getTopic());
		  tmp.setHeight(newwidget.getHeight());
		  tmp.setWidth(newwidget.getWidth());
		  tmp.setTitle(newwidget.getTitle());
		  return widgetRepository.save(tmp);
	  }  
	
	    @GetMapping("/api/widgets/{wId}")
	    public Optional<Widget> findWidgetById(@PathVariable("wId") int wId) { // find one
	        return widgetRepository.findById(wId);
	    } 
	    
		@DeleteMapping("/api/widgets/{wId}")
		public void deleteWidget(@PathVariable("wId") int wId) { // delete
			widgetRepository.deleteById(wId);
		}
	    

}
