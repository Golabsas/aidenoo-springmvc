package com.aidenoo.data.model;

public class Login {

	private String idsociete;
	private String login;
	private String passwordx;
	private String email;
	private String role;
	
	public Login() { super(); }
	public Login(String idsociete, String login, String passwordx, String email, String role) {
		this();
		this.login = login;
		this.passwordx = passwordx;
		this.email = email;
		this.role = role;
		this.idsociete = idsociete;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordx() {
		return passwordx;
	}

	public void setPasswordx(String passwordx) {
		this.passwordx = passwordx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdsociete() {
		return idsociete;
	}

	public void setIdsociete(String idsociete) {
		this.idsociete = idsociete;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return String.format("Login [idsociete=%s, login=%s, passwordx=%s, email=%s, role=%s]", idsociete, login,
				passwordx, email, role);
	}
	
}
