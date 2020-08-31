package com.ma.petclinicdata.services;

import java.util.Set;

import com.ma.petclinicdata.model.Vet;

public interface VetInterface {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
	
}
