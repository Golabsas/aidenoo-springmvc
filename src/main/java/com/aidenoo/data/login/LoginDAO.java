package com.aidenoo.data.login;

import java.util.List;

import com.aidenoo.data.common.Dao;

public interface LoginDAO extends Dao<Login> {
	public List<Login> readAll();
}
