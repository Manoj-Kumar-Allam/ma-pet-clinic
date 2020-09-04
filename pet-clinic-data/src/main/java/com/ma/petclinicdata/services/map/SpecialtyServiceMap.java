package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Specialty;
import com.ma.petclinicdata.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}

	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	@Override
	public Boolean delete(Specialty object) {
		return super.delete(object);
	}

	@Override
	public Specialty deleteById(Long id) {
		return super.deletById(id);
	}

}
