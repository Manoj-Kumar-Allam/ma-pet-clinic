package com.ma.petclinicdata.services;

import java.util.List;

import com.ma.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
