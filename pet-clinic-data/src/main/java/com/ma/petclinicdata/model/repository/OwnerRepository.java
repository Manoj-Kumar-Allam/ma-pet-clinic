package com.ma.petclinicdata.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ma.petclinicdata.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastname);
	
	Iterable<Owner> findAll();
	
	Optional<Owner> findById(Long id);
	
	<S extends Owner> S save(S entity);
	
	
}
