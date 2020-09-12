package com.ma.petclinicweb.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	/*@GetMapping({"", "/", "/index", "/index.html"})
	public String listOwners(Model model) {
		model.addAttribute("owners", this.ownerService.findAll());
		return "owners/index";
	}*/
	
	@InitBinder
	public void showAllowedFields(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("/find")
	public String find(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/findOwners";
	}
	
	@GetMapping({"", "/"})
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if(owner.getLastName() == null) {
			owner.setLastName("");  // for broad search
		}
		
		List<Owner> findAllByLastNameLike = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		
		if(findAllByLastNameLike.isEmpty()) {
			result.rejectValue("lastName", "notFound", "notFound");
			return "owners/findOwners";
		} else if(findAllByLastNameLike.size() == 1) {
			Owner next = findAllByLastNameLike.iterator().next();
			return "redirect:/owners/" + next.getId();
		} else {
			model.addAttribute("selections", findAllByLastNameLike);
			return "owners/ownerList";
		}
		
	}
	
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable String ownerId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("owners/ownerDetails");
		mav.addObject(this.ownerService.findById(Long.valueOf(ownerId)));
		return mav;
	}

}

