package com.aidenoo.data.Famserv;

import java.util.List;

import com.aidenoo.data.dao.Dao;

public interface FamservDAO extends Dao<Famserv> {
	public List<Famserv> readAll();
}
