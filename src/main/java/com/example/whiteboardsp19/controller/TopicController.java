package com.example.whiteboardsp19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Topic;

import com.example.whiteboardsp19.services.TopicService;

@RestController
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @DeleteMapping("/api/topics/{tid}")
    public List<Topic> deleteTopic(@PathVariable("tid") int tid) {
        return topicService.deleteTopic(tid);
    }


    @PutMapping("/api/topics/{tid}")
    public Topic updateTopic(@PathVariable("tid") Integer tid, @RequestBody Topic newTopic) {
        return topicService.updateTopic(tid, newTopic);
    }

    @PostMapping("/api/lessons/{lid}/topic")
    public List<Topic> createTopic(@PathVariable("lid") Integer lid, @RequestBody Topic topic) {
        return topicService.createTopic(lid, topic);
    }

    @GetMapping("/api/lessons/{lid}/topic")
    public List<Topic> findAllTopics(@PathVariable("lid") Integer lid) {
        return topicService.findAllTopics(lid);
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer tid) {
        return topicService.findTopicById(tid);
    }

}
