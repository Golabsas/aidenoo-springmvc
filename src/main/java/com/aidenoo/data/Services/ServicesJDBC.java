package com.aidenoo.data.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.security.SecurityCommon;

class FamservMapper implements RowMapper<Services> {

	@Override
	public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Services(
				rs.getString("idsociete"), 
				rs.getString("type"), 
				rs.getString("groupetarif"),
				rs.getString("libelle"),
				rs.getInt("specialisation")
				);
	}
	
};

@Repository
public class ServicesJDBC implements ServicesDAO {
	private static final Logger logger = Logger.getLogger(ServicesJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO services (idsociete, type, groupetarif, libelle, specialisation)"
												+ " VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM services WHERE type=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE services SET groupetarif=?, specialisation=?, libelle=? WHERE type=? AND idsociete=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM services WHERE type=";
	private static final String _SELECT_ALL_ = "SELECT * FROM services WHERE idsociete=";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean create(Services t) {
		
		if (read().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getIdsociete(), t.getType(), t.getLibelle()
		});
		logger.info("create()" + t.toString());
		return res > 0;
	}

	@Override
	public List<Services> read() {
		logger.info("read()");
		return jdbcTemplate.query(
				_SELECT_ALL_ + "'" + SecurityCommon.retrieveLoggedUserSociete() + "'" , 
				new FamservMapper());
	}

	@Override
	public Services search(String type) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+type+"'" + 
				" AND idsociete='" + SecurityCommon.retrieveLoggedUserSociete() + "'"; 
		
		List<Services> famservs = jdbcTemplate.query(SQL_QUERY, new FamservMapper());
		Services result = famservs.get(0);
		
		logger.info("read(" + type + ") -> " + result.toString());
		return result;
	}

	@Override
	public boolean update(Services t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getGroupetarif(), t.getSpecialisation(), t.getLibelle(), t.getType(), t.getIdsociete()
		});
		logger.info("update()" + t.toString());
		return res > 0;
	}

	@Override
	public boolean delete(Services t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getType(), t.getIdsociete()
		});
		logger.info("delete()" + t.toString());
		return res > 0;
	}

}
