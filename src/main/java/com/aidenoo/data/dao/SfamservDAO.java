package com.aidenoo.data.dao;

import java.util.List;

import com.aidenoo.data.model.Sfamserv;

public interface SfamservDAO extends Dao<Sfamserv> {
	public List<Sfamserv> readAll();

}
