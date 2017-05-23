package com.aidenoo.data.Sfamserv;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SfamservService {
	
	@Autowired
	private SfamservDAO sfarmservdb;
	
	
	public Sfamserv retrieve(String type) {
		return this.sfarmservdb.search(type);
	}
	
	public List<Sfamserv> listAll() {	
		return this.sfarmservdb.read();
	}
	
	public void add(Sfamserv famserv) {
		this.sfarmservdb.create(famserv);
	}
	
	public void update(Sfamserv famserv) {
		this.sfarmservdb.update(famserv);
	}
	
	public void delete(Sfamserv famserv) {
		this.sfarmservdb.delete(famserv);
	}

}
