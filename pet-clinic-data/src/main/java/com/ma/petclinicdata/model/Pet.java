package com.ma.petclinicdata.model;

import java.time.LocalTime;

public class Pet extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private PetType petType;
	private Owner owner;
	private LocalTime birthDate;
	
	
	public Pet() {
		super();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public PetType getPetType() {
		return petType;
	}


	public void setPetType(PetType petType) {
		this.petType = petType;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public LocalTime getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalTime birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "Pet [petType=" + petType + ", owner=" + owner + ", birthDate=" + birthDate + "]";
	}
	
	
	
}
