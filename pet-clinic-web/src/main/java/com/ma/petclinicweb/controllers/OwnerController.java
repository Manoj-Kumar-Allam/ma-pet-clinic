package com.ma.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ma.petclinicdata.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listOwners(Model model) {
		model.addAttribute("owners", this.ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String find() {
		return "notimplemented";
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable String ownerId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("owners/ownerDetails");
		mav.addObject(this.ownerService.findById(Long.valueOf(ownerId)));
		return mav;
	}

}
