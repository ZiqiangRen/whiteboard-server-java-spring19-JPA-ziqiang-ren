package com.example.whiteboardsp19.model;

public class Module {
	private Integer id;
	private String title;
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
	

}
