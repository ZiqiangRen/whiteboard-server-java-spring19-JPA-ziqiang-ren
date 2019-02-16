package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.model.Module;

@Service
public class ModuleService {

    private final CourseService courseService;

    private List<Module> modules = new ArrayList<>();

    @Autowired
    public ModuleService(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostConstruct
    public void init() {
        Module cs4500Module1 = new Module(9123, "Module 1");
        Module cs4500Module2 = new Module(9234, "Module 2");
        Lesson lesson1 = new Lesson(1232, "Lesson1");
        Lesson lesson2 = new Lesson(2342, "Lesson1");

        List<Lesson> module1Lessons = new ArrayList<>();
        module1Lessons.add(lesson1);
        module1Lessons.add(lesson2);
        cs4500Module1.setLessons(module1Lessons);
        modules.add(cs4500Module1);
        modules.add(cs4500Module2);
    }

    public List<Module> deleteModule(Integer mid) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	            if (curModules.get(j).getId().equals(mid)) {
	            	curModules.remove(j);
	            	allCourses.get(i).setModules(curModules);
	                return curModules;
	            }
	        }
    	}
    	return null;
    }


    public Module updateModule(Integer mid, Module newModule) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (int i=0; i<allCourses.size(); ++i) {
    		List<Module> curModules = allCourses.get(i).getModules();
	        for (int j=0; j<curModules.size(); ++j) {
	            if (curModules.get(j).getId().equals(mid)) {
	            	allCourses.get(i).getModules().get(j).setLessons(newModule.getLessons());
	            	allCourses.get(i).getModules().get(j).setTitle(newModule.getTitle());
	                return allCourses.get(i).getModules().get(j);
	            }
	        }
    	}
    	return null;
    }

    public List<Module> createModule(Integer cid, Module module) {
        Course curCourse = courseService.findCourseById(cid);
        List<Module> curModules = curCourse.getModules();
        module.setId((int) (Math.random() * 10000));
        curModules.add(module);
        curCourse.setModules(curModules);
        courseService.updateCourse(cid, curCourse);
        return curModules;
    }

    public List<Module> findAllModules(Integer cid) {
        return courseService.findCourseById(cid).getModules();
    }

    public Module findModuleById(Integer mid) {
    	List<Course> allCourses = courseService.findAllCourses();
    	for (Course curCourse: allCourses) {
    		List<Module> curModules = curCourse.getModules();
	        for (Module module : curModules) {
	            if (module.getId().equals(mid)) {
	                return module;
	            }
	        }
    	}
    	return null;
    }

}