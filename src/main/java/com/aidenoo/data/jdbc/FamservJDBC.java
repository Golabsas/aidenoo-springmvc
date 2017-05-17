package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.data.Famserv.FamservDAO;
import com.aidenoo.data.model.Famserv;
import com.aidenoo.security.SecurityCommon;

class FamservMapper implements RowMapper<Famserv> {

	@Override
	public Famserv mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Famserv(
				rs.getString("idsociete"), 
				rs.getString("type"), 
				rs.getString("libelle"));
	}
	
};

@Repository
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
		logger.info("create()" + t.toString());
		return res > 0;
	}

	@Override
	public List<Famserv> readAll() {
		logger.info("readAll()");
		return jdbcTemplate.query(_SELECT_ALL_, new FamservMapper());
	}

	@Override
	public Famserv read(String type) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+type+"'" + " AND idsociete=" 
				+ SecurityCommon.retrieveLoggedUserSociete(); // FIX : Add idsociete 
		
		List<Famserv> famservs = jdbcTemplate.query(SQL_QUERY, new FamservMapper());
		Famserv result = famservs.get(0);
		
		logger.info("read(" + type + ") -> " + result.toString());
		return result;
	}

	@Override
	public boolean update(Famserv t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getLibelle(), t.getType(), t.getIdsociete()
		});
		logger.info("update()" + t.toString());
		return res > 0;
	}

	@Override
	public boolean delete(Famserv t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getType(), t.getIdsociete()
		});
		logger.info("delete()" + t.toString());
		return res > 0;
	}

}
