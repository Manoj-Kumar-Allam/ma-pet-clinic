package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Speciality;
import com.ma.petclinicdata.repository.SpecialityRepository;
import com.ma.petclinicdata.services.SpecialtyService;

@Service
@Profile("jpa")
public class SpecialityJPAService implements SpecialtyService {
	
	private final SpecialityRepository specialityRepository;

	public SpecialityJPAService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		this.specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return this.specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return this.specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		this.specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.specialityRepository.deleteById(id);
	}

}
