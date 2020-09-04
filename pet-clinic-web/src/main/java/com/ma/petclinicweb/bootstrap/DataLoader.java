package com.ma.petclinicweb.bootstrap;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.model.PetType;
import com.ma.petclinicdata.model.Specialty;
import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.OwnerService;
import com.ma.petclinicdata.services.PetTypeService;
import com.ma.petclinicdata.services.SpecialtyService;
import com.ma.petclinicdata.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;

	private final VetService vetService;
	
	private final PetTypeService petTypeService;
	
	private final SpecialtyService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = this.petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}

	private void loadData() {
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
		pet.setPetType(savedDog);
		pet.setName("Beeni");
		pet.setOwner(owner);
		pet.setBirthDate(LocalTime.now());
		
		Pet pet2 = new Pet();
		pet2.setPetType(savedCat);
		pet2.setName("Buk");
		pet2.setOwner(owner);
		pet2.setBirthDate(LocalTime.now());
		
		owner.getPets().add(pet);
		owner.getPets().add(pet2);
		
		System.out.println("Loaded Owners..");

		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		
		Specialty savedRadiology = this.specialtyService.save(radiology);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		
		Specialty savedDentistry = this.specialtyService.save(dentistry);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		
		Specialty savedSurgery = this.specialtyService.save(surgery);
		
		Vet vet = new Vet();
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		vet.getSpecialties().add(savedSurgery);
		vet.getSpecialties().add(savedRadiology);
		vet.getSpecialties().add(savedDentistry);
		
		this.vetService.save(vet);

		System.out.println("Loaded Vets");
	}

}
