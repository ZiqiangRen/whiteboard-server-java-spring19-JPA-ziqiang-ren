package com.example.whiteboardsp19.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private Integer id;
	private String title;
	private List<Module> modules = new ArrayList<Module>();
	public Course(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	

}
