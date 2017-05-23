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
public class AidenooUserDetail implements UserDetailsService {
	
	@Autowired
	LoginDAO db;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AidenooUser aidenooUser = null;
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(!"".equals(username)) {
			
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			aidenooUser = new AidenooUser(username, 
					db.readPassword(username), true, true, true, true, authorities, 
					username, db.readSociete(username));
			
		} else {
			aidenooUser = new AidenooUser("NA", "NA", true, true, true, true, authorities, null, null);
		}
		
		return aidenooUser;
	}
}
