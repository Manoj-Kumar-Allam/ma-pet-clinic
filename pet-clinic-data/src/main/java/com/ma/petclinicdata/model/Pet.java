package com.ma.petclinicdata.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	private PetType petType;
	
	@ManyToOne
	private Owner owner;
	
	@Column(name="birth_date")
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
