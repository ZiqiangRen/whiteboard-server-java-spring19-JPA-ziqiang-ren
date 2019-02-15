package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Module;
import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.services.CourseService;

@RestController
public class ModuleService {
	CourseService MyCourseService = CourseService.getInstance();
	Module cs4500Module1 = new Module(9123, "Module 1");
	Module cs4500Module2 = new Module(9234, "Module 2");
	Lesson Lesson1 = new Lesson(1232, "Lesson1");
	Lesson Lesson2 = new Lesson(2342, "Lesson1");
	//Course[] courses = {cs5610, cs4500};
	List<Module> modules = new ArrayList<Module>();
	List<Lesson> module1Lessons = new ArrayList<Lesson>();
	{
		module1Lessons.add(Lesson1);
		module1Lessons.add(Lesson2);
		cs4500Module1.setLessons(module1Lessons);
		modules.add(cs4500Module1);
		modules.add(cs4500Module2);
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public List<Module> deleteModule(
			@PathVariable("mid") int mid) {
		modules = modules.stream()
					.filter(module -> module.getId() != mid)
					.collect(Collectors.toList());
		return modules;
	}
	
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(
			@PathVariable("mid") Integer mid,
			@RequestBody Module newModule) {
		for(Module module: modules) {
			if(module.getId().equals(mid)) {
				module.setTitle(newModule.getTitle());
				return module;
			}
		}
		return null;
	}
	
	@PostMapping("/api/courses/{cid}/modules")
	public List<Module> createModule(
			@PathVariable("cid") Integer cid,
			@RequestBody Module module) {
		Course curCourse = MyCourseService.findCourseById(cid);
		module.setId((int)(Math.random() * 1000));
		modules.add(module);
		return modules;
	}
	
	@GetMapping("/api/course/{cid}/modules")
	public List<Module> findAllModules(
			@PathVariable("cid") Integer cid) {
		return modules;
	}
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(
			@PathVariable("mid") Integer mid) {
		for(Module module: modules) {
			if(module.getId().equals(mid)) {
				return module;
			}
		}
		return null;
	}

}
