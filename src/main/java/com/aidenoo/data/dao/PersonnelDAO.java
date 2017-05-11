package com.aidenoo.data.dao;

import java.util.List;

import com.aidenoo.data.model.Personnel;

public interface PersonnelDAO extends Dao<Personnel> {
	public List<Personnel> readAll();
}
