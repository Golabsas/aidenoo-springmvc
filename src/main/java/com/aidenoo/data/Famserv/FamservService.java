package com.aidenoo.data.Famserv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidenoo.data.dao.FamservDAO;
import com.aidenoo.data.model.Famserv;
import com.aidenoo.security.SecurityCommon;

@Service
public class FamservService {
	
	@Autowired
	private FamservDAO famservdb;
	
	public List<Famserv> ListFamserv() {
		return famservdb.readAll();
	}
	
	public void addFamserv() {
		String idsociete = SecurityCommon.retrieveLoggedUserSociete();
		
		// TODO : a finir
	}
	
	public void delete(String type) {
		famservdb.delete(famservdb.read(type));
	}

}
