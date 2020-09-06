package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.PetType;
import com.ma.petclinicdata.repository.PetTypeRepository;
import com.ma.petclinicdata.services.PetTypeService;

@Service
@Profile("jpa")
public class PetTypeJPAService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;
	
	public PetTypeJPAService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		this.petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return this.petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return this.petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		this.petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.petTypeRepository.deleteById(id);
	}

}
