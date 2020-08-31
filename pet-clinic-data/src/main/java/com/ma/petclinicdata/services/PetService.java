package com.ma.petclinicdata.services;

import java.util.Set;

import com.ma.petclinicdata.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet vet);
	
	Set<Pet> findAll();
}
