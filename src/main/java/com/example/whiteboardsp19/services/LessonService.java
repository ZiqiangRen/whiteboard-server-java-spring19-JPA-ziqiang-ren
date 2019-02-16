package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.model.Module;

@Service
public class LessonService {

    private final CourseService courseService;
    private final ModuleService moduleService;

    private List<Lesson> lessons = new ArrayList<>();

    @Autowired
    public LessonService(CourseService courseService, ModuleService moduleService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
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

    public List<Lesson> deleteLesson(Integer id) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	            if (curLessons.get(k).getId().equals(id)) {
	            	curLessons.remove(k);
	            	allCourses.get(i).getModules().get(j).setLessons(curLessons);
	                return curLessons;
	            }
	        }
	        }
    	}
    	return null;
    }


    public Lesson updateLesson(Integer id, Lesson newLesson) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	            if (curLessons.get(k).getId().equals(id)) {
	            	allCourses.get(i).getModules().get(j).getLessons().get(k).setTopics(newLesson.getTopics());
	            	allCourses.get(i).getModules().get(j).getLessons().get(k).setTitle(newLesson.getTitle());
	                return allCourses.get(i).getModules().get(j).getLessons().get(k);
	            }
	        }
	        }
    	}
    	return null;
    }

    public List<Lesson> createLesson(Integer mid, Lesson lesson) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	            if (curModules.get(j).getId().equals(mid)) {
	            	List<Lesson> curLessons = curModules.get(j).getLessons();
	            	lesson.setId((int) (Math.random() * 10000));
	            	System.out.println(allCourses.get(i).getModules().get(j));
	            	curLessons.add(lesson);
	            	allCourses.get(i).getModules().get(j).setLessons(curLessons);
	            	return curLessons;
	            }
	        }
    	}
    	return null;
    }

    public List<Lesson> findAllLessons(Integer id) {
    	System.out.println("hitdasdadasd");
        return moduleService.findModuleById(id).getLessons();
    }

    public Lesson findLessonById(Integer id) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	        	List<Lesson> curLessons = curModules.get(j).getLessons();
	        	for(int k=0; k<curLessons.size(); ++k) {
	            if (curLessons.get(k).getId().equals(id)) {
	            	return curLessons.get(k);
	            }
	        }
	        }
    	}
    	return null;
    }

}