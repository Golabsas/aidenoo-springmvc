package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aidenoo.data.dao.FamservDAO;
import com.aidenoo.data.model.Famserv;

class FamservMapper implements RowMapper<Famserv> {

	@Override
	public Famserv mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Famserv(
				rs.getString("idsociete"), 
				rs.getString("type"), 
				rs.getString("libelle"));
	}
	
};

public class FamservJDBC implements FamservDAO {
	private static final Logger logger = Logger.getLogger(FamservJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO famserv (idsociete, type, libelle) VALUES(?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM famserv WHERE type=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE famserv SET libelle=? WHERE type=? AND idsociete=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM famserv WHERE type=";
	private static final String _SELECT_ALL_ = "SELECT * FROM famserv";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean create(Famserv t) {
		
		if (readAll().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getIdsociete(), t.getType(), t.getLibelle()
		});
		return res > 0;
	}

	@Override
	public List<Famserv> readAll() {
		return jdbcTemplate.query(_SELECT_ALL_, new FamservMapper());
	}

	@Override
	public Famserv read(String type) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+type+"'"; // FIX : Add idsociete 
		List<Famserv> famservs = jdbcTemplate.query(SQL_QUERY, new FamservMapper());
		
		return famservs.get(0);
	}

	@Override
	public boolean update(Famserv t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getLibelle(), t.getType(), t.getIdsociete()
		});
		return res > 0;
	}

	@Override
	public boolean delete(Famserv t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getType(), t.getIdsociete()
		});
		return res > 0;
	}

}
