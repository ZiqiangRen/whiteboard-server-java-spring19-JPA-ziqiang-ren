package com.example.whiteboardsp19.model;

import javax.persistence.Entity;

@Entity
public class HeadingWidget extends Widget{
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
