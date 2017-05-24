package com.aidenoo.data.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {
	
	@Autowired
	private ServicesDAO servicesdb;
	
	
	public Services retrieve(String type) {
		return this.servicesdb.search(type);
	}
	
	public List<Services> listAll() {	
		return this.servicesdb.read();
	}
	
	public void add(Services famserv) {
		this.servicesdb.create(famserv);
	}
	
	public void update(Services famserv) {
		this.servicesdb.update(famserv);
	}
	
	public void delete(Services famserv) {
		this.servicesdb.delete(famserv);
	}

}
