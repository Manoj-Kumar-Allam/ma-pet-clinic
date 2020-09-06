package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Speciality;
import com.ma.petclinicdata.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtyService {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public Boolean delete(Speciality object) {
		return super.delete(object);
	}

	@Override
	public Speciality deleteById(Long id) {
		return super.deletById(id);
	}

}
