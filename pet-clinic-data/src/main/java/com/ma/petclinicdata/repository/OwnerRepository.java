package com.ma.petclinicdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.ma.petclinicdata.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastname);
	
}
