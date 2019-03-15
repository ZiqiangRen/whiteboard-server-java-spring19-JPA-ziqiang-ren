package com.example.whiteboardsp19.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="modules")
public class Module {
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
	private String title;
	
    @ManyToOne()
    @JsonIgnore
    private Course course; //parent course of this module
	  
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course; // first set parent course
		if(!course.getModules().contains(this)) {
			course.getModules().add(this);   // then go to parent course, and set its children modules
		}
	}
	@OneToMany(mappedBy="module")
	private List<Lesson> lessons;
	
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
