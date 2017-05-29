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
		else
			throw new RuntimeException("Impossible de recuperrer l'identifiant de connexion");
	}
	
	public static String retrieveLoggedUserSociete() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof LoggedUser)
			return ((LoggedUser) principal).getIdSociete();
		else
			throw new RuntimeException("Impossible de recuperer le nom de la societe");
	}

}
