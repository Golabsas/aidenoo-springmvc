package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aidenoo.data.dao.ServicesDAO;
import com.aidenoo.data.model.Services;


class ServicesMapper implements RowMapper<Services> {

	@Override
	public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Services(
				rs.getString("type"), 
				rs.getString("groupetarif"), 
				rs.getString("libelle"), 
				rs.getInt("specialisation"), 
				rs.getString("idsociete"));
	}
	
};

public class ServicesJDBC implements ServicesDAO {
	private static final Logger logger = Logger.getLogger(ServicesJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO services (type, groupetarif, libelle, specialisation, idsociete) "
												+ "VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM services WHERE type=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE services SET groupetarif=? libelle=? specialisation=? WHERE type=? AND idsociete=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM services WHERE type=";
	private static final String _SELECT_ALL_ = "SELECT * FROM services";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean create(Services t) {
		if (this.readAll().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getType(), t.getGroupetarif(), t.getLibelle(), 
				t.getSpecialisation(), t.getIdsociete()
		});
		return res > 0;
	}

	@Override
	public Services read(String type) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+type+"'"; // FIX : Add idsociete 
		List<Services> services = jdbcTemplate.query(SQL_QUERY, new ServicesMapper());
		
		return services.get(0);
	}

	@Override
	public boolean update(Services t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getGroupetarif(), t.getLibelle(), t.getSpecialisation(),
				t.getType(), t.getIdsociete()
		});
		return res > 0;
	}

	@Override
	public boolean delete(Services t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object [] {
				t.getType(), t.getIdsociete()
		});
		return res > 0;
	}

	@Override
	public List<Services> readAll() {
		return jdbcTemplate.query(_SELECT_ALL_, new ServicesMapper());
	}

}
