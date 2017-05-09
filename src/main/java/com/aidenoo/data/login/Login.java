package com.aidenoo.data.login;

public class Login {

	private String login;
	private String passwordx;
	private String question;
	private String response;
	
	public Login(String login, String passwordx, String question, String response) {
		this.login = login;
		this.passwordx = passwordx;
		this.question = question;
		this.response = response;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return String.format("Login [login=%s, passwordx=%s, question=%s, response=%s]", login, passwordx, question,
				response);
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
	
	
}
