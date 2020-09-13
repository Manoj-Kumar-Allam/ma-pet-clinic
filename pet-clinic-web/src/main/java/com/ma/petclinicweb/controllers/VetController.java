package com.ma.petclinicweb.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ma.petclinicdata.model.Vet;
import com.ma.petclinicdata.services.VetService;

@Controller
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@GetMapping({"/vets", "/vets.html", "/vets/index", "/vets/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", this.vetService.findAll());
		return "vets/index";
	}
	
	@GetMapping("api/vets")
	public @ResponseBody Set<Vet> jsonViewOfVets() {
		return this.vetService.findAll();
	}
}
