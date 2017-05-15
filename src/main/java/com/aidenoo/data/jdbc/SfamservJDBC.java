package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aidenoo.data.dao.SfamservDAO;
import com.aidenoo.data.model.Sfamserv;

class SfamservMapper implements RowMapper<Sfamserv> {

	@Override
	public Sfamserv mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Sfamserv(
				rs.getString("idsociete"), 
				rs.getString("sfam"), 
				rs.getString("libelle"));
	}
	
};

public class SfamservJDBC implements SfamservDAO {
	private static final Logger logger = Logger.getLogger(SfamservJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO sfamserv (idsociete, sfam, libelle) VALUES(?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM sfamserv WHERE sfam=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE sfamserv SET libelle=? WHERE sfam=? AND idsociete=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM sfamserv WHERE sfam=";
	private static final String _SELECT_ALL_ = "SELECT * FROM sfamserv";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean create(Sfamserv t) {
		
		if (readAll().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getIdsociete(), t.getSfam(), t.getLibelle()
		});
		return res > 0;
	}

	@Override
	public List<Sfamserv> readAll() {
		return jdbcTemplate.query(_SELECT_ALL_, new SfamservMapper());
	}

	@Override
	public Sfamserv read(String sfam) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+sfam+"'"; // FIX : Add idsociete 
		List<Sfamserv> sfamservs = jdbcTemplate.query(SQL_QUERY, new SfamservMapper());
		
		return sfamservs.get(0);
	}

	@Override
	public boolean update(Sfamserv t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getLibelle(), t.getSfam(), t.getIdsociete()
		});
		return res > 0;
	}

	@Override
	public boolean delete(Sfamserv t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getSfam(), t.getIdsociete()
		});
		return res > 0;
	}
}
