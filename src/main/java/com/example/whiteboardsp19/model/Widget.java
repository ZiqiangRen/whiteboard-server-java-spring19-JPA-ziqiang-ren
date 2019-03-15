package com.example.whiteboardsp19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="widgets")
public class Widget {
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
    
	  private String title;// title is wtype
	  private int width;
	  private int height;
	  
	    public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
		@ManyToOne()
	    @JsonIgnore
	    private Topic topic; //parent topic of this widget
		  
		public Topic getTopic() {
			return topic;
		}

		public void setTopic(Topic topic) {
			this.topic = topic; // first set parent topic
			if(!topic.getWidgets().contains(this)) {
				topic.getWidgets().add(this);   // then go to parent topic, and set its children widgets
			}
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

}

