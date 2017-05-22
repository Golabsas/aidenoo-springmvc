package com.aidenoo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aidenoo.security.*;


@Controller
public class WelcomeController {
	
	@Autowired
	private SecurityCommon security;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		String userName = SecurityCommon.retrieveLoggedUserName();
		String idSociete = security.retrieveLoggedUserSociete();

		model.addAttribute("activeHome", "active");
		model.addAttribute("name", userName);
		model.addAttribute("society", idSociete);
		return "welcome";
	}
}
