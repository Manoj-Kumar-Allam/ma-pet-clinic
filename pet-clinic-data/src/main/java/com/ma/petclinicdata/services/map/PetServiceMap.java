package com.ma.petclinicdata.services.map;

import java.util.Set;

import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Boolean delete(Pet object) {
		return super.delete(object);
	}

	@Override
	public Pet deleteById(Long id) {
		return super.deletById(id);
	}

}
