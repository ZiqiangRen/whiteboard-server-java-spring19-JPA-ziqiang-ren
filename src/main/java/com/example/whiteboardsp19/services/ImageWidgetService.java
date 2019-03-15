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
public class ImageWidgetService {
	  @Autowired
	  TopicRepository topicRepository;
	  @Autowired
	  ImageWidgetRepository imageWidgetRepository;
	
	  @PutMapping("/api/image/widgets/{wId}")
	  public ImageWidget updateImageWidget(@PathVariable("wId") int wId, @RequestBody ImageWidget newwidget) { // update
		  ImageWidget tmp = imageWidgetRepository.findById(wId).orElse(null);
		  //tmp.setTopic(newwidget.getTopic());
		  tmp.setHeight(newwidget.getHeight());
		  tmp.setWidth(newwidget.getWidth());
		  tmp.setTitle(newwidget.getTitle());
		  tmp.setSrc(newwidget.getSrc());
		  return imageWidgetRepository.save(tmp);
	  }  
	
	    @GetMapping("/api/image/widgets/{wId}")
	    public Optional<ImageWidget> findImageWidgetById(@PathVariable("wId") int wId) { // find one
	        return imageWidgetRepository.findById(wId);
	    } 
	    
		@DeleteMapping("/api/image/widgets/{wId}")
		public void deleteImageWidget(@PathVariable("wId") int wId) { // delete
			imageWidgetRepository.deleteById(wId);
		}
	    

}
