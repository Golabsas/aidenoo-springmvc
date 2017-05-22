package com.aidenoo.data.Famserv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aidenoo.security.SecurityCommon;

@Controller
public class FamservController {

	@Autowired
	FamservService service;
	
	private List<Famserv> famservs;

	@RequestMapping(value = "/list-famservs")
	public String listFamserv(ModelMap model) {
		String idSociete = SecurityCommon.retrieveLoggedUserSociete();
		famservs = service.listOnly(idSociete);
		model.addAttribute("famservs", famservs);
		return "list-famservs";
	}

	@RequestMapping(value = "/delete-famserv", method = RequestMethod.GET)
	public String removeFamserv(@RequestParam int index, ModelMap model) {
		
		service.delete(famservs.get(validIndex(index)));
		return "redirect:list-famservs";
	}

	@RequestMapping(value = "/add-famserv", method = RequestMethod.GET)
	public String AddFamserv(ModelMap model) {
		model.addAttribute("famserv", new Famserv());
		return "famserv";
	}

	@RequestMapping(value = "/add-famserv", method = RequestMethod.POST)
	public String AddFamserv(ModelMap model, @Valid Famserv famserv, BindingResult result) {

		if (result.hasErrors()) {
			return "famserv";
		}

		famserv.setIdsociete(SecurityCommon.retrieveLoggedUserSociete());

		service.add(famserv);
		model.clear();
		return "redirect:list-famservs";
	}

	@RequestMapping(value = "/update-famserv", method = RequestMethod.GET)
	public String updateFamserv(@RequestParam int index, ModelMap model) {
		
		Famserv famserv = famservs.get(validIndex(index));

		model.clear();
		model.addAttribute("famserv", famserv);
		return "famserv";
	}

	private int validIndex(int index) {
		
		if (index < 0 || index >= famservs.size())
			throw new RuntimeException("Invalid index");
		
		return index;
	}

	@RequestMapping(value = "/update-famserv", method = RequestMethod.POST)
	public String updateFamserv(ModelMap model, @Valid Famserv famserv, BindingResult result) {

		if (result.hasErrors()) {
			return "famserv";
		}

		famserv.setIdsociete(SecurityCommon.retrieveLoggedUserSociete());

		service.update(famserv);
		model.clear();
		return "redirect:list-famservs";
	}

}
