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
@Table(name="lessons")
public class Lesson {
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
	  private String title;
	  
	    @ManyToOne()
	    @JsonIgnore
	    private Module module; //parent module of this lesson
		  
		public Module getModule() {
			return module;
		}

		public void setModule(Module module) {
			this.module = module; // first set parent module
			if(!module.getLessons().contains(this)) {
				module.getLessons().add(this);   // then go to parent module, and set its children lessons
			}
		}
		
		@OneToMany(mappedBy="lesson")
		private List<Topic> topics;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

