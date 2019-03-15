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
public class ParagraphWidgetService {
	  @Autowired
	  TopicRepository topicRepository;
	  @Autowired
	  ParagraphWidgetRepository paragraphWidgetRepository;
	
	  @PutMapping("/api/paragraph/widgets/{wId}")
	  public ParagraphWidget updateParagraphWidget(@PathVariable("wId") int wId, @RequestBody ParagraphWidget newwidget) { // update
		  ParagraphWidget tmp = paragraphWidgetRepository.findById(wId).orElse(null);
		  //tmp.setTopic(newwidget.getTopic());
		  tmp.setHeight(newwidget.getHeight());
		  tmp.setWidth(newwidget.getWidth());
		  tmp.setTitle(newwidget.getTitle());
		  tmp.setText(newwidget.getText());
		  return paragraphWidgetRepository.save(tmp);
	  }  
	
	    @GetMapping("/api/paragraph/widgets/{wId}")
	    public Optional<ParagraphWidget> findParagraphWidgetById(@PathVariable("wId") int wId) { // find one
	        return paragraphWidgetRepository.findById(wId);
	    } 
	    
		@DeleteMapping("/api/paragraph/widgets/{wId}")
		public void deleteParagraphWidget(@PathVariable("wId") int wId) { // delete
			paragraphWidgetRepository.deleteById(wId);
		}
	    

}
