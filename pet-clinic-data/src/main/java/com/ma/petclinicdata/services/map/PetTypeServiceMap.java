package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.PetType;
import com.ma.petclinicdata.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public Boolean delete(PetType object) {
		return super.delete(object);
	}

	@Override
	public PetType deleteById(Long id) {
		return super.deletById(id);
	}

}
