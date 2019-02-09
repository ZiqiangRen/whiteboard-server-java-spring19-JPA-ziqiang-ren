package com.example.whiteboardsp19.model;

import java.util.List;

public class Module {
	private Integer id;
	private String title;
	private List<Lesson> lessons;
	public Module(Integer id, String title) {
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
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	

}
