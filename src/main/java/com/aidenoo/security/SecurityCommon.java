package com.aidenoo.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityCommon {
	public static String retrieveLoggedUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof LoggedUser)
			return ((LoggedUser) principal).getLogin();
		
		return principal.toString();
	}
	
	public static String retrieveLoggedUserSociete() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof LoggedUser)
			return ((LoggedUser) principal).getIdSociete();
		
		return principal.toString();
	}

}
