package com.ma.petclinicdata.model;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
	private Set<Visit> visits = new HashSet<>();
	
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

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	@Override
	public String toString() {
		return "Pet [petType=" + petType + ", owner=" + owner + ", birthDate=" + birthDate + "]";
	}
	
	
	
}
