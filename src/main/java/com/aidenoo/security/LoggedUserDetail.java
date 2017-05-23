package com.aidenoo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aidenoo.data.Login.LoginDAO;

@Service("userDetailsService")
public class LoggedUserDetail implements UserDetailsService {
	
	@Autowired
	LoginDAO db;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoggedUser aidenooUser = null;
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(!"".equals(username)) {
			
			// TODO: Verifier que le login entrer est dans la BDD
			
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			aidenooUser = new LoggedUser(username, 
					db.readPassword(username), true, true, true, true, authorities, 
					username, db.readSociete(username));
			
		} else {
			aidenooUser = new LoggedUser("NA", "NA", true, true, true, true, authorities, null, null);
		}
		
		return aidenooUser;
	}
}
