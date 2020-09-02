package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
		return super.save(object);
	}

	@Override
	public Boolean delete(Vet object) {
		return super.delete(object);
	}

	@Override
	public Vet deleteById(Long id) {
		return super.deletById(id);
	}

}
