package com.ma.petclinicdata.model;

import java.time.LocalTime;

public class Pet {
	
	private PetType petType;
	private Owner owner;
	private LocalTime birthDate;
	
	
	public Pet() {
		super();
	}


	public Pet(PetType petType, Owner owner, LocalTime birthDate) {
		super();
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
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
