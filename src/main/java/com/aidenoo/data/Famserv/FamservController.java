package com.aidenoo.data.Famserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FamservController {
	
	@Autowired
	FamservService service;

	@RequestMapping(value="/famille")
	public String newFamille(ModelMap model) {
		model.addAttribute("famservs", service.ListFamserv());
		return "famille";
	}
	
	@RequestMapping(value="/delete-famserv", method=RequestMethod.GET)
	public String removeFamille(@RequestParam String type, ModelMap model) {
		service.delete(type);
		return "redirect:famille";
	}


	@RequestMapping(value="/famille", method=RequestMethod.POST)
	public String listFamille() {
		return "redirect:/famille";
	}
}
