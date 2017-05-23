package com.aidenoo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AidenooUser extends User {

	private static final long serialVersionUID = -8363347222300026262L;
	
	private final String login;
	private final String idSociete;

	public AidenooUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String login, String idSociete) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.login = login;
		this.idSociete = idSociete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLogin() {
		return login;
	}

	public String getIdSociete() {
		return idSociete;
	}

}
