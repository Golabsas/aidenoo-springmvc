package com.aidenoo.data.model;

public class Login {

	private String login;
	private String passwordx;
	private String email;
	private String role;
	private String company;
	
	public Login() { super(); }
	public Login(String login, String passwordx, String email, String role, String company) {
		this();
		this.login = login;
		this.passwordx = passwordx;
		this.email = email;
		this.role = role;
		this.company = company;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return String.format("Login [login=%s, passwordx=%s, email=%s, role=%s, company=%s]", login, passwordx, email,
				role, company);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
