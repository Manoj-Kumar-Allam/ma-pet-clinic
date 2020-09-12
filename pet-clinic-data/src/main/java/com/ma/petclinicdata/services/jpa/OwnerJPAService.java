package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.repository.OwnerRepository;
import com.ma.petclinicdata.services.OwnerService;

@Service
@Profile("jpa")
public class OwnerJPAService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	
	@Autowired
	public OwnerJPAService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		this.ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		Optional<Owner> optinalOwner = this.ownerRepository.findById(id);
		// return optinalOwner.isPresent() ? optinalOwner.get() : null;
		return optinalOwner.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return this.ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		this.ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return this.ownerRepository.findAllByLastNameLike(lastName) ;
	}
	
	
}
