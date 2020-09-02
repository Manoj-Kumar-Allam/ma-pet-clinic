package com.ma.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.OwnerService;
import com.ma.petclinicdata.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}


	@Override
	public void run(String... args) throws Exception {
		
			Owner owner = new Owner();
			owner.setFirstName("Manoj");
			owner.setLastName("Kumar");
			
			this.ownerService.save(owner);
			
			System.out.println("Loaded Owners..");
			
			Vet vet = new Vet();
			vet.setFirstName("Sam");
			vet.setLastName("Axe");
			
			this.vetService.save(vet);
			
			System.out.println("Loaded Vets");
	}

}
