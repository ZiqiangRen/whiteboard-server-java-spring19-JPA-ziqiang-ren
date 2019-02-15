package com.example.whiteboardsp19.model;

import java.util.List;

public class Lesson {
	  private int id;
	  private String title;
	  private List<Topic> topics;
	public Lesson(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	  
}

