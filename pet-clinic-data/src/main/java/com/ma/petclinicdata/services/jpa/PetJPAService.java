package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.repository.PetRepository;
import com.ma.petclinicdata.services.PetService;

@Service
@Profile("jpa")
public class PetJPAService implements PetService {
	
	private final PetRepository petRepository;

	public PetJPAService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		this.petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return this.petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return this.petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		this.petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.petRepository.deleteById(id);
	}

}
