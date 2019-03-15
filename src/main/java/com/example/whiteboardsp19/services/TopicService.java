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
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Widget;
import com.example.whiteboardsp19.repository.TopicRepository;

@RestController
public class TopicService {
  @Autowired
  TopicRepository topicRepository;
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  WidgetRepository widgetRepository;
  
  @PostMapping("/api/lessons/{lid}/topic")
  public List<Topic> createTopic(@PathVariable("lid") Integer lId, @RequestBody Topic topic) {
	  Lesson lesson = lessonRepository.findById(lId).orElse(null);
	  topic.setLesson(lesson);
	  lessonRepository.save(lesson);
	  topicRepository.save(topic);
	  return lesson.getTopics();
  }
  
  @PutMapping("/api/topics/{topicId}")
  public Topic updatetopic(@PathVariable("topicId") int tId, @RequestBody Topic newtopic) { // update
	  Topic tmp = topicRepository.findById(tId).orElse(null);
	  tmp.setTitle(newtopic.getTitle());
	  tmp.setWidgets(newtopic.getWidgets());
	  return topicRepository.save(tmp);
  }  
  
  @GetMapping("/api/topics/{topicId}/lesson")
	public Lesson findParentLesson(@PathVariable("topicId") int tId) { // get parent
	  Topic topic = topicRepository.findById(tId).orElse(null);
		return topic.getLesson();
	}
  
	@DeleteMapping("/api/topics/{topicId}")
	public void deleteTopic(@PathVariable("topicId") int tId) { // delete
		topicRepository.deleteById(tId);
	}
	
    @GetMapping("/api/lessons/{lid}/topic")
    public List<Topic> findAllTopics(@PathVariable("lid") Integer lId) {
    	Lesson lesson = lessonRepository.findById(lId).orElse(null);
    	return lesson.getTopics();
    }
    
    @GetMapping("/api/topics/{topicId}")
    public Optional<Topic> findtopicById(@PathVariable("topicId") int tId) { // find one
        return topicRepository.findById(tId);
    }    
  
    @PutMapping("/api/topics/{topicId}/widget")
    public List<Widget> createWidget(@PathVariable("topicId") int tId,@RequestBody Widget widget) {
  	  Topic topic = topicRepository.findById(tId).orElse(null);
  	  widget.setTopic(topic);
  	  topicRepository.save(topic);
  	  widgetRepository.save(widget);
  	  return topic.getWidgets();
    }

    @GetMapping("/api/topics/{topicId}/widget")
    public List<Widget> findAllWidgets(@PathVariable("topicId") Integer tId) {
    	Topic topic = topicRepository.findById(tId).orElse(null);
    	return topic.getWidgets();
    }
    
  

  

}