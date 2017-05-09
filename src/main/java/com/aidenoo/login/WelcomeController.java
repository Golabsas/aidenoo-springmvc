package com.aidenoo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aidenoo.security.SecurityCommon;

@Controller
public class WelcomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		String userName = SecurityCommon.retrieveLoggedUserName();

		model.addAttribute("activeHome", "active");
		model.addAttribute("name", userName);
		return "welcome";
	}
}
