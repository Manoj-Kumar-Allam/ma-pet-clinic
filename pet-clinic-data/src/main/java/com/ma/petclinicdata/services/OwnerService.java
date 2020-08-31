package com.ma.petclinicdata.services;

import com.ma.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
}
