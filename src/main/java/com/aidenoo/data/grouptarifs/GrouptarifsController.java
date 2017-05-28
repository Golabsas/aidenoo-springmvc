package com.aidenoo.data.grouptarifs;

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
public class GrouptarifsController {

	@Autowired
	GrouptarifsService service;

	private List<Grouptarifs> grouptarifss;

	@RequestMapping(value = "/list-grouptarifss")
	public String listFamserv(ModelMap model) {
		grouptarifss = service.listAll();
		model.addAttribute("grouptarifss", grouptarifss);
		return "list-grouptarifss";
	}

	@RequestMapping(value = "/delete-grouptarifs", method = RequestMethod.GET)
	public String removeFamserv(@RequestParam int index, ModelMap model) {
		
		service.delete(grouptarifss.get(validIndex(index)));
		return "redirect:list-famservs";
	}

	@RequestMapping(value = "/add-grouptarifs", method = RequestMethod.GET)
	public String AddFamserv(ModelMap model) {
		model.addAttribute("grouptarifs", new Grouptarifs());
		return "grouptarifs";
	}

	@RequestMapping(value = "/add-grouptarifs", method = RequestMethod.POST)
	public String AddFamserv(ModelMap model, @Valid Grouptarifs grouptarifs, BindingResult result) {

		if (result.hasErrors()) {
			return "grouptarifs";
		}

		grouptarifs.setIdsociete(SecurityCommon.retrieveLoggedUserSociete());

		service.add(grouptarifs);
		model.clear();
		return "redirect:list-grouptarifss";
	}

	@RequestMapping(value = "/update-grouptarifs", method = RequestMethod.GET)
	public String updateFamserv(@RequestParam int index, ModelMap model) {
		
		Grouptarifs grouptarifs = grouptarifss.get(validIndex(index));

		model.clear();
		model.addAttribute("grouptarifs", grouptarifs);
		return "grouptarifs";
	}

	private int validIndex(int index) {
		
		if (index < 0 || index >= grouptarifss.size())
			throw new RuntimeException("Invalid index");
		
		return index;
	}

	@RequestMapping(value = "/update-grouptarifs", method = RequestMethod.POST)
	public String updateFamserv(ModelMap model, @Valid Grouptarifs grouptarifs, BindingResult result) {

		if (result.hasErrors()) {
			return "grouptarifs";
		}

		grouptarifs.setIdsociete(SecurityCommon.retrieveLoggedUserSociete());

		service.update(grouptarifs);
		model.clear();
		return "redirect:list-grouptarifss";
	}

}
