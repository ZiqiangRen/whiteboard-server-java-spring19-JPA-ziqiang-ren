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
import com.example.whiteboardsp19.model.*;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Widget;
@RestController
@CrossOrigin(origins = "*", allowCredentials="true")
public class ListWidgetService {
	  @Autowired
	  TopicRepository topicRepository;
	  @Autowired
	  ListWidgetRepository listWidgetRepository;
	
	  @PutMapping("/api/list/widgets/{wId}")
	  public ListWidget updateListWidget(@PathVariable("wId") int wId, @RequestBody ListWidget newwidget) { // update
		  ListWidget tmp = listWidgetRepository.findById(wId).orElse(null);
		  //tmp.setTopic(newwidget.getTopic());
		  tmp.setHeight(newwidget.getHeight());
		  tmp.setWidth(newwidget.getWidth());
		  tmp.setTitle(newwidget.getTitle());
		  tmp.setItems(newwidget.getItems());
		  tmp.setOrdered(newwidget.getOrdered());
		  return listWidgetRepository.save(tmp);
	  }  
	
	    @GetMapping("/api/list/widgets/{wId}")
	    public Optional<ListWidget> findListWidgetById(@PathVariable("wId") int wId) { // find one
	        return listWidgetRepository.findById(wId);
	    } 
	    
		@DeleteMapping("/api/list/widgets/{wId}")
		public void deleteListWidget(@PathVariable("wId") int wId) { // delete
			listWidgetRepository.deleteById(wId);
		}
	    

}
