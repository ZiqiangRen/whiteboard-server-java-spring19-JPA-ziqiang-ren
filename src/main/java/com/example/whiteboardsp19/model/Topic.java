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
@Table(name="topics")
public class Topic {
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
    
	  private String title;
	  
	    @ManyToOne()
	    @JsonIgnore
	    private Lesson lesson; //parent lesson of this topic
		  
		public Lesson getLesson() {
			return lesson;
		}

		public void setLesson(Lesson lesson) {
			this.lesson = lesson; // first set parent lesson
			if(!lesson.getTopics().contains(this)) {
				lesson.getTopics().add(this);   // then go to parent lesson, and set its children topics
			}
		}
		
		@OneToMany(mappedBy="topic")
		private List<Widget> widgets;

	  
	  
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
	public List<Widget> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

}

