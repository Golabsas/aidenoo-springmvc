package com.aidenoo.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityCommon {
	public static String retrieveLoggedUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof AidenooUser)
			return ((AidenooUser) principal).getLogin();
		
		return principal.toString();
	}
	
	public static String retrieveLoggedUserSociete() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof AidenooUser)
			return ((AidenooUser) principal).getIdSociete();
		
		return principal.toString();
	}

}
