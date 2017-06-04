package com.aidenoo.data.Sfamserv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.security.SecurityService;

class FamservMapper implements RowMapper<Sfamserv> {

	@Override
	public Sfamserv mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Sfamserv(
				rs.getString("idsociete"), 
				rs.getString("sfam"), 
				rs.getString("libelle")
				);
	}
	
};

@Repository
public class SfamservJDBC implements SfamservDAO {
	private static final Logger logger = Logger.getLogger(SfamservJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO sfamserv (idsociete, sfam, libelle) VALUES(?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM sfamserv WHERE sfam=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE sfamserv SET libelle=? WHERE sfam=? AND idsociete=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM sfamserv WHERE sfam=";
	private static final String _SELECT_ALL_ = "SELECT * FROM sfamserv WHERE idsociete=";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SecurityService securityService;

	@Override
	public boolean create(Sfamserv t) {
		
		if (read().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getIdsociete(), t.getSfam(), t.getLibelle()
		});
		
		logger.info("create()" + t.toString());
		return res > 0;
	}

	@Override
	public List<Sfamserv> read() {
		logger.info("read()");
		return jdbcTemplate.query(
				_SELECT_ALL_ + "'" + securityService.retrieveLoggedUserSociete() + "'" , 
				new FamservMapper());
	}

	@Override
	public Sfamserv search(String sfam) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+sfam+"'" + 
				" AND idsociete='" + securityService.retrieveLoggedUserSociete() + "'"; 
		
		List<Sfamserv> famservs = jdbcTemplate.query(SQL_QUERY, new FamservMapper());
		Sfamserv result = famservs.get(0);
		
		logger.info("read(" + sfam + ") -> " + result.toString());
		return result;
	}

	@Override
	public boolean update(Sfamserv t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getLibelle(), t.getSfam(), t.getIdsociete()
		});
		
		logger.info("update()" + t.toString());
		return res > 0;
	}

	@Override
	public boolean delete(Sfamserv t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getSfam(), t.getIdsociete()
		});
		
		logger.info("delete()" + t.toString());
		return res > 0;
	}

}
