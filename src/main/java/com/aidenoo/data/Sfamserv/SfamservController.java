package com.aidenoo.data.Sfamserv;

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
public class SfamservController {

	@Autowired
	SfamservService service;
	
	@Autowired
	private SecurityCommon security;
	
	private List<Sfamserv> sfamservs;

	@RequestMapping(value = "/list-sfamservs")
	public String listFamserv(ModelMap model) {
		sfamservs = service.listAll();
		model.addAttribute("sfamservs", sfamservs);
		return "list-sfamservs";
	}

	@RequestMapping(value = "/delete-sfamserv", method = RequestMethod.GET)
	public String removeFamserv(@RequestParam int index, ModelMap model) {
		
		service.delete(sfamservs.get(validIndex(index)));
		return "redirect:list-famservs";
	}

	@RequestMapping(value = "/add-sfamserv", method = RequestMethod.GET)
	public String AddFamserv(ModelMap model) {
		model.addAttribute("sfamserv", new Sfamserv());
		return "sfamserv";
	}

	@RequestMapping(value = "/add-sfamserv", method = RequestMethod.POST)
	public String AddFamserv(ModelMap model, @Valid Sfamserv sfamserv, BindingResult result) {

		if (result.hasErrors()) {
			return "sfamserv";
		}

		sfamserv.setIdsociete(security.retrieveLoggedUserSociete());

		service.add(sfamserv);
		model.clear();
		return "redirect:list-sfamservs";
	}

	@RequestMapping(value = "/update-sfamserv", method = RequestMethod.GET)
	public String updateFamserv(@RequestParam int index, ModelMap model) {
		
		Sfamserv sfamserv = sfamservs.get(validIndex(index));

		model.clear();
		model.addAttribute("sfamserv", sfamserv);
		return "sfamserv";
	}

	private int validIndex(int index) {
		
		if (index < 0 || index >= sfamservs.size())
			throw new RuntimeException("Invalid index");
		
		return index;
	}

	@RequestMapping(value = "/update-sfamserv", method = RequestMethod.POST)
	public String updateFamserv(ModelMap model, @Valid Sfamserv sfamserv, BindingResult result) {

		if (result.hasErrors()) {
			return "sfamserv";
		}

		sfamserv.setIdsociete(security.retrieveLoggedUserSociete());

		service.update(sfamserv);
		model.clear();
		return "redirect:list-sfamservs";
	}

}
