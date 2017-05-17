package com.aidenoo.data.Famserv;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidenoo.data.model.Famserv;
import com.aidenoo.security.SecurityCommon;

@Service
public class FamservService {
	
	@Autowired
	private FamservDAO famservdb;
	
	public List<Famserv> lists() {	
		String idSociete = SecurityCommon.retrieveLoggedUserSociete();
		List<Famserv> list = this.famservdb.readAll();

		removeOthersSociety(list, idSociete);
		
		return list;
	}

	private void removeOthersSociety(List<Famserv> list, String idSociete) {
		Iterator<Famserv> it = list.iterator();
		
		while(it.hasNext()) {
			Famserv fam = it.next();
			if (!fam.getIdsociete().equals(idSociete)) {
				it.remove();
			}
		}
	}
	
	public void add(Famserv famserv) {
		this.famservdb.create(famserv);
	}
	
	public void update(Famserv famserv) {
		this.famservdb.update(famserv);
	}
	
	public void delete(String type) {
		this.famservdb.delete(famservdb.read(type));
	}

}
