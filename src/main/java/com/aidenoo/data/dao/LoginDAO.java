package com.aidenoo.data.dao;

import java.util.List;

import com.aidenoo.data.model.Login;

public interface LoginDAO extends Dao<Login> {
	public List<Login> readAll();
}
