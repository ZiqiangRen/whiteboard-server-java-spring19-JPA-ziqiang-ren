package com.example.whiteboardsp19.model;

import javax.persistence.Entity;

@Entity
public class ParagraphWidget extends Widget{
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
