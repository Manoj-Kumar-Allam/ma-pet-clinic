package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Speciality;
import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.SpecialtyService;
import com.ma.petclinicdata.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if (object.getSpecialties() != null && !object.getSpecialties().isEmpty()) {
				object.getSpecialties().forEach(specialty -> {
					if (specialty.getId() == null) {
						Speciality savedSpecialty = this.specialtyService.save(specialty);
						specialty.setId(savedSpecialty.getId());
					}
				});
			} else {
				throw new RuntimeException("Atleast One Specialty should be there");
			}
			return super.save(object);
		} else {
			throw new RuntimeException("Object Can not be Null");
		}

	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deletById(id);
	}

}
