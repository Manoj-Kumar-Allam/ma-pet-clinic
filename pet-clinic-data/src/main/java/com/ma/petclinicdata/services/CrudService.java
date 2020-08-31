package com.ma.petclinicdata.services;

import java.util.Set;

public interface CrudService<T, ID> {
	
	Set<T> findAll();
	
	T findById(ID id);
	
	T save(T object);
	
	Boolean delete(T object);
	
	T deleteById(ID id);
	
}
