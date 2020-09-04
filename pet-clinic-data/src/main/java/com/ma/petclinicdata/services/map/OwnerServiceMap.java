package com.ma.petclinicdata.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.services.OwnerService;
import com.ma.petclinicdata.services.PetService;
import com.ma.petclinicdata.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetService petService;
	
	private final PetTypeService petTypeService;

	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(this.petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is Required");
					}
					
					if(pet.getId() == null) {
						Pet savedPet = this.petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		} else {
			throw new RuntimeException("Object Can not be Null");
		}
	}

	@Override
	public Boolean delete(Owner object) {
		return super.delete(object);
	}

	@Override
	public Owner deleteById(Long id) {
		return super.deletById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

}
