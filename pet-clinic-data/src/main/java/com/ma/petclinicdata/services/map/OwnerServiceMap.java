package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Boolean delete(Owner object) {
		return super.delete(object);
	}

	@Override
	public Owner deleteById(Long id) {
		return super.deletById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

}
