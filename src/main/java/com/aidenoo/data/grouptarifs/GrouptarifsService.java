package com.aidenoo.data.grouptarifs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrouptarifsService {
	
	@Autowired
	private GrouptarifsDAO grouptarifsdb;
	
	
	public Grouptarifs retrieve(String type) {
		return this.grouptarifsdb.search(type);
	}
	
	public List<Grouptarifs> listAll() {	
		return this.grouptarifsdb.read();
	}
	
	public void add(Grouptarifs famserv) {
		this.grouptarifsdb.create(famserv);
	}
	
	public void update(Grouptarifs famserv) {
		this.grouptarifsdb.update(famserv);
	}
	
	public void delete(Grouptarifs famserv) {
		this.grouptarifsdb.delete(famserv);
	}

}
