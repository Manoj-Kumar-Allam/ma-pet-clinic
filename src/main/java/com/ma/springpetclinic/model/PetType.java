package com.ma.springpetclinic.model;

public class PetType {

	private String name;


	public PetType() {
		super();
	}

	public PetType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PetType [name=" + name + "]";
	}
	
	
}
