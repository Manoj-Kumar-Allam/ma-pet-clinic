package com.ma.petclinicdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.ma.petclinicdata.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
