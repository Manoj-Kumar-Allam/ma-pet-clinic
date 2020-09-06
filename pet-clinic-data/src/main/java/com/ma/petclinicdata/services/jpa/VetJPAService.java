package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.model.repository.VetRepositroy;
import com.ma.petclinicdata.services.VetService;

@Service
@Profile("jpa")
public class VetJPAService implements VetService {
	
	private final VetRepositroy vetRepositroy;

	public VetJPAService(VetRepositroy vetRepositroy) {
		this.vetRepositroy = vetRepositroy;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		this.vetRepositroy.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return this.vetRepositroy.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return this.vetRepositroy.save(object);
	}

	@Override
	public void delete(Vet object) {
		this.vetRepositroy.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.vetRepositroy.deleteById(id);
	}
	
}
