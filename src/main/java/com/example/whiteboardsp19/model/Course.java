package com.example.whiteboardsp19.model;


import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.whiteboardsp19.model.Faculty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	   
	private String title;
	
    @ManyToOne()
    @JsonIgnore
    private Faculty author;
	  
	@OneToMany(mappedBy="course")
	private List<Module> modules;
	  
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Faculty getAuthor() {
		return author;
	}

	public void setAuthor(Faculty author) {
		this.author = author;
		if(!author.getAuthoredCourses().contains(this)) {
		     author.getAuthoredCourses().add(this);
		}
	}
	

}
