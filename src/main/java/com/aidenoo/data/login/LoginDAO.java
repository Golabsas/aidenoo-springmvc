package com.aidenoo.data.login;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {
	public boolean create(Login login);
	public List<Login> readAll();
	public boolean update(Login login);
	public boolean delete(Login login);
	public void close();

}
