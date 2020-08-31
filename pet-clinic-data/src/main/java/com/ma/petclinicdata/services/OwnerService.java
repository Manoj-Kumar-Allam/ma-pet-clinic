package com.ma.petclinicdata.services;

import java.util.Set;

import com.ma.petclinicdata.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
}
