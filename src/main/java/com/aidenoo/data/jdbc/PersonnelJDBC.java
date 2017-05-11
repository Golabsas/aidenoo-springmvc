package com.aidenoo.data.jdbc;

import org.springframework.stereotype.Repository;

import com.aidenoo.data.dao.PersonnelDAO;
import com.aidenoo.data.model.Personnel;

@Repository
public class PersonnelJDBC implements PersonnelDAO {
	
	// TODO Terminer l'implementation;

	@Override
	public boolean create(Personnel t) {
		return false;
	}

	@Override
	public Personnel read(String name) {
		return null;
	}

	@Override
	public boolean update(Personnel t) {
		return false;
	}

	@Override
	public boolean delete(Personnel t) {
		return false;
	}

}
