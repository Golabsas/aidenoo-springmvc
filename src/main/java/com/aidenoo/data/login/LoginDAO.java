package com.aidenoo.data.login;

import java.util.List;

public interface LoginDAO {
	public boolean create(Login login);
	public List<Login> readAll();
	public boolean update(Login login);
	public boolean delete(Login login);
	public void close();

}
