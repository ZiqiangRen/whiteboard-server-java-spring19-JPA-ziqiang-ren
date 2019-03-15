package com.example.whiteboardsp19.model;

import javax.persistence.Entity;

@Entity
public class ImageWidget extends Widget{
	private String src;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	

}
