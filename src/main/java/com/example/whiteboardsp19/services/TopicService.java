package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Topic;

@Service
public class TopicService {

    private final CourseService courseService;
    private final ModuleService moduleService;
    private final LessonService lessonService;

    private List<Topic> topics = new ArrayList<>();

    @Autowired
    public TopicService(CourseService courseService, ModuleService moduleService, LessonService lessonService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
        this.lessonService = lessonService;
    }

    @PostConstruct
    public void init() {
//        Module cs4500Module1 = new Module(9123, "Module 1");
//        Module cs4500Module2 = new Module(9234, "Module 2");
//        Lesson lesson1 = new Lesson(1232, "Lesson1");
//        Lesson lesson2 = new Lesson(2342, "Lesson1");
//
//        List<Lesson> module1Lessons = new ArrayList<>();
//        module1Lessons.add(lesson1);
//        module1Lessons.add(lesson2);
//        cs4500Module1.setLessons(module1Lessons);
//        modules.add(cs4500Module1);
//        modules.add(cs4500Module2);
    }

    public List<Topic> deleteTopic(Integer id) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	        		List<Topic> curTopics = curLessons.get(k).getTopics();
	        		for(int l=0; l<curTopics.size(); ++l) {
			            if (curTopics.get(l).getId().equals(id)) {
			            	curTopics.remove(l);
			            	allCourses.get(i).getModules().get(j).getLessons().get(k).setTopics(curTopics);
			                return curTopics;
	            }
	        }}
	        }
    	}
    	return null;
    }


    public Topic updateTopic(Integer id, Topic newTopic) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	        		List<Topic> curTopics = curLessons.get(k).getTopics();
	        		for(int l=0; l<curTopics.size(); ++l) {
			            if (curTopics.get(l).getId().equals(id)) {
			            	allCourses.get(i).getModules().get(j).getLessons().get(k).getTopics().get(l).setWidgets(newTopic.getWidgets());
			            	allCourses.get(i).getModules().get(j).getLessons().get(k).getTopics().get(l).setTitle(newTopic.getTitle());
			                return allCourses.get(i).getModules().get(j).getLessons().get(k).getTopics().get(l);
		            }
	        }}
	        }
    	}
    	return null;
    }

    public List<Topic> createTopic(Integer lid, Topic topic) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
		            if (curLessons.get(k).getId().equals(lid)) {
		            	List<Topic> curTopics = curLessons.get(k).getTopics();
		            	topic.setId((int) (Math.random() * 10000));
		            	curTopics.add(topic);
		            	allCourses.get(i).getModules().get(j).getLessons().get(k).setTopics(curTopics);
		            	return curTopics;
		            }
	        }}
    	}
    	return null;
    }

    public List<Topic> findAllTopics(Integer id) {
        return lessonService.findLessonById(id).getTopics();
    }

    public Topic findTopicById(Integer id) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	        		List<Topic> curTopics = curLessons.get(k).getTopics();
	        		for(int l=0; l<curTopics.size(); ++l) {
			            if (curTopics.get(l).getId().equals(id)) {
			            	return curTopics.get(l);
	            }
	        }}
	        }
    	}
    	return null;
    }

}
