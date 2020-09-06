package com.ma.petclinicdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.ma.petclinicdata.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
