package com.aidenoo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.aidenoo.data.Login.LoginDAO;

@Service
public class SecurityCommon {
	
	@Autowired
	private LoginDAO db;
	
	public static String retrieveLoggedUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	public String retrieveLoggedUserSociete() {
		return db.readSociete(retrieveLoggedUserName());
	}

}
