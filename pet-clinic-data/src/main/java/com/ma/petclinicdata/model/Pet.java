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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
	
	@Builder.Default
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
	private Set<Visit> visits = new HashSet<>();
	
}
