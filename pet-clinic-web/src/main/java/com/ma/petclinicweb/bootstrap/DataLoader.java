package com.ma.petclinicweb.bootstrap;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.model.PetType;
import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.OwnerService;
import com.ma.petclinicdata.services.PetTypeService;
import com.ma.petclinicdata.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;

	private final VetService vetService;
	
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		
		PetType savedDog = this.petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		
		PetType savedCat = this.petTypeService.save(cat);
		
		
		Owner owner = new Owner();
		owner.setFirstName("Manoj");
		owner.setLastName("Kumar");
		owner.setAddress("123 Paris Corner");
		owner.setCity("Chennai");
		owner.setTelephone("3284723442");

		this.ownerService.save(owner);
		
		Pet pet = new Pet();
		pet.setPetType(dog);
		pet.setName("Beeni");
		pet.setOwner(owner);
		pet.setBirthDate(LocalTime.now());
		
		owner.getPets().add(pet);
		System.out.println("Loaded Owners..");

		Vet vet = new Vet();
		vet.setFirstName("Sam");
		vet.setLastName("Axe");

		this.vetService.save(vet);

		System.out.println("Loaded Vets");
	}

}
