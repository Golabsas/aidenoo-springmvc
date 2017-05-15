package com.aidenoo.data.dao;

import java.util.List;

import com.aidenoo.data.model.Famserv;

public interface FamservDAO extends Dao<Famserv> {
	public List<Famserv> readAll();
}
