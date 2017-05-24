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

import com.aidenoo.data.Login.Login;
import com.aidenoo.data.Login.LoginDAO;

@Service("userDetailsService")
public class LoggedUserDetail implements UserDetailsService {

	@Autowired
	LoginDAO db;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LoggedUser aidenooUser = null;
		List<GrantedAuthority> authorities = new ArrayList<>();

		if (!"".equals(username)) {
			
			try {
				Login user = db.search(username);

				authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

				aidenooUser = new LoggedUser(username, user.getPasswordx(), true, true, true, true, authorities,
						username, user.getIdsociete());
			} catch (Exception e) {
				aidenooUser = new LoggedUser("NA", "NA", true, true, true, true, authorities, null, null);
			}

		} else {
			aidenooUser = new LoggedUser("NA", "NA", true, true, true, true, authorities, null, null);
		}

		return aidenooUser;
	}
}
