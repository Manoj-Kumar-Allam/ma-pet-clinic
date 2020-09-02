package com.ma.petclinicdata.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.ma.petclinicdata.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Number> {

	protected Map<Long, T> dataMap = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<T>(dataMap.values());
	}

	T findById(ID id) {
		return dataMap.get(id);
	}

	T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(generateId());
			}
			dataMap.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object can not be null");
		}

		return object;
	}

	T deletById(ID id) {
		return dataMap.remove(id);
	}

	Boolean delete(T object) {
		return dataMap.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	private Long generateId() {
		Long nextId = null;
		try {
			nextId = Collections.max(dataMap.keySet()) + 1; 
		} catch(NoSuchElementException e) {
			nextId = 1l;
		}
		return nextId;
	}

}
