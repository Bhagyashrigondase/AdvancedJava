package com.blogs.dto;

import lombok.Getter;
import lombok.Setter;


public class CategoryDTO extends BaseDTO {
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryDTO [name=" + name + ", description=" + description + "]";
	}
	

}
