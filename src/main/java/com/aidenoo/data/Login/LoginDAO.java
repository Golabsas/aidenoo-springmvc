package com.aidenoo.data.Login;

import com.aidenoo.data.dao.IDao;

public interface LoginDAO extends IDao<Login> {
	String readPassword(String login);
	String readSociete(String Login);
	String readRole(String login);
}
