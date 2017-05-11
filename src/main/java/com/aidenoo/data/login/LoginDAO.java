package com.aidenoo.data.login;

import java.util.List;

import com.aidenoo.data.common.CrudDao;

public interface LoginDAO extends CrudDao<Login> {
	public List<Login> readAll();
}
