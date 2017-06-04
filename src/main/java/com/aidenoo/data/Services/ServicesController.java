package com.aidenoo.data.Services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aidenoo.security.SecurityService;

@Controller
public class ServicesController {

	@Autowired
	ServicesService sService;

	@Autowired
	private SecurityService securityService;

	private List<Services> servicess;

	@RequestMapping(value = "/list-services")
	public String listFamserv(ModelMap model) {
		servicess = sService.listAll();
		model.addAttribute("servicess", servicess);
		return "list-services";
	}

	@RequestMapping(value = "/delete-services", method = RequestMethod.GET)
	public String removeFamserv(@RequestParam int index, ModelMap model) {
		
		sService.delete(servicess.get(validIndex(index)));
		return "redirect:list-services";
	}

	@RequestMapping(value = "/add-services", method = RequestMethod.GET)
	public String AddFamserv(ModelMap model) {
		model.addAttribute("services", new Services());
		return "services";
	}

	@RequestMapping(value = "/add-services", method = RequestMethod.POST)
	public String AddFamserv(ModelMap model, @Valid Services services, BindingResult result) {

		if (result.hasErrors()) {
			return "services";
		}

		services.setIdsociete(securityService.retrieveLoggedUserSociete());

		sService.add(services);
		model.clear();
		return "redirect:list-services";
	}

	@RequestMapping(value = "/update-services", method = RequestMethod.GET)
	public String updateFamserv(@RequestParam int index, ModelMap model) {
		
		Services services = servicess.get(validIndex(index));

		model.clear();
		model.addAttribute("services", services);
		return "services";
	}

	private int validIndex(int index) {
		
		if (index < 0 || index >= servicess.size())
			throw new RuntimeException("Invalid index");
		
		return index;
	}

	@RequestMapping(value = "/update-services", method = RequestMethod.POST)
	public String updateFamserv(ModelMap model, @Valid Services services, BindingResult result) {

		if (result.hasErrors()) {
			return "services";
		}

		services.setIdsociete(securityService.retrieveLoggedUserSociete());

		sService.update(services);
		model.clear();
		return "redirect:list-services";
	}

}
