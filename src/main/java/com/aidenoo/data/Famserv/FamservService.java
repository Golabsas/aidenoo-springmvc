package com.aidenoo.data.Famserv;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamservService {
	
	@Autowired
	private FamservDAO famservdb;
	
	
	public Famserv retrieve(String type) {
		return this.famservdb.search(type);
	}
	
	public List<Famserv> listAll() {	
		return this.famservdb.read();
	}
	
	public void add(Famserv famserv) {
		this.famservdb.create(famserv);
	}
	
	public void update(Famserv famserv) {
		this.famservdb.update(famserv);
	}
	
	public void delete(Famserv famserv) {
		this.famservdb.delete(famserv);
	}

}
