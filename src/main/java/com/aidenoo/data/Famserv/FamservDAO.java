package com.aidenoo.data.Famserv;

import java.util.List;

import com.aidenoo.data.dao.Dao;
import com.aidenoo.data.model.Famserv;

public interface FamservDAO extends Dao<Famserv> {
	public List<Famserv> readAll();
}
