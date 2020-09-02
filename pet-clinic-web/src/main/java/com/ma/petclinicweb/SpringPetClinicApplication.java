package com.ma.petclinicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.ma.petclinicweb", "com.ma.petclinicdata"})
public class SpringPetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPetClinicApplication.class, args);
	}

}
