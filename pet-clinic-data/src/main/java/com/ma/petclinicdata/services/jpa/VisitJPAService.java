package com.ma.petclinicdata.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Visit;
import com.ma.petclinicdata.model.repository.VisitRepository;
import com.ma.petclinicdata.services.VisitService;

@Service
@Profile("jpa")
public class VisitJPAService implements VisitService {
	
	private final VisitRepository visitRepository;

	public VisitJPAService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		this.visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return this.visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return this.visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		this.visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.visitRepository.deleteById(id);
	}
	
}
