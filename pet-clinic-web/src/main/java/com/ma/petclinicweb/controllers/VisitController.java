package com.ma.petclinicweb.controllers;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ma.petclinicdata.model.Pet;
import com.ma.petclinicdata.model.Visit;
import com.ma.petclinicdata.services.PetService;
import com.ma.petclinicdata.services.VisitService;

@Controller
public class VisitController {

	private final VisitService visitService;

	private final PetService PetService;

	public VisitController(VisitService visitService, com.ma.petclinicdata.services.PetService petService) {
		super();
		this.visitService = visitService;
		PetService = petService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
		
		dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(LocalDate.parse(text));
			}
		});
	}

	/**
	 * Called before each and every @RequestMapping annotated method. 2 goals: -
	 * Make sure we always have fresh data - Since we do not use the session scope,
	 * make sure that Pet object always has an id (Even though id is not part of the
	 * form fields)
	 * 
	 * @param petId
	 * @return Pet
	 */
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
		Pet pet = this.PetService.findById(petId);
		model.addAttribute("pet", pet);
		Visit visit = new Visit();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		return visit;
	}

	// Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is
	// called
	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable Long petId, Model model) {
		return "pets/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is
	// called
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		} else {
			this.visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}
}
