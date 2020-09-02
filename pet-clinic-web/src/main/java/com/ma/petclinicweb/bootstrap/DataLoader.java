package com.ma.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.OwnerService;
import com.ma.petclinicdata.services.VetService;
import com.ma.petclinicdata.services.map.OwnerServiceMap;
import com.ma.petclinicdata.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	
	private final VetService vetService;

	
	public DataLoader() {
		super();
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}


	@Override
	public void run(String... args) throws Exception {
		
			Owner owner = new Owner();
			owner.setId(1l);
			owner.setFirstName("Manoj");
			owner.setLastName("Kumar");
			
			this.ownerService.save(owner);
			
			System.out.println("Loaded Owners..");
			
			Vet vet = new Vet();
			vet.setId(1l);
			vet.setFirstName("Sam");
			vet.setLastName("Axe");
			
			this.vetService.save(vet);
			
			System.out.println("Loaded Vets");
	}

}
