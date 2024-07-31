package com.app.dto;

import com.app.Entities.Type;

public class CreateDTO {
	
	private String name;
	private Type type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CreateDTO [name=" + name + ", type=" + type + "]";
	}
	public CreateDTO(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}
	public CreateDTO() {
		super();
	}
	
	

}
