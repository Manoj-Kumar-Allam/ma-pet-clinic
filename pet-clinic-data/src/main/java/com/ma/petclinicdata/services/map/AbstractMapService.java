package com.ma.petclinicdata.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
	
	protected Map<ID, T> dataMap = new HashMap<>();
	
	Set<T >findAll() {
		return new HashSet<T>(dataMap.values());
	}
	
	T findById(ID id) {
		return dataMap.get(id);
	}
	
	T save(ID id, T object) {
		dataMap.put(id, object);
		return object;
	}
	
	T deletById(ID id) {
		return dataMap.remove(id);
	}
	
	Boolean delete(T object) {
		return dataMap.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
}
