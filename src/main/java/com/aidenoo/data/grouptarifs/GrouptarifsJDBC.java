package com.aidenoo.data.grouptarifs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.security.SecurityCommon;

class GrouptarifsMapper implements RowMapper<Grouptarifs> {

	@Override
	public Grouptarifs mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Grouptarifs(
				rs.getString("idsociete"), 
				rs.getString("groupe"), 
				rs.getString("libelle"),
				
				rs.getFloat("tarifjour"),
				rs.getFloat("tarifnuit"),
				rs.getFloat("tarifjdf"),
				rs.getFloat("tarifndf"),
				
				rs.getFloat("tarifmj"),
				rs.getFloat("tarifmn"),
				rs.getFloat("tarifmjdf"),
				rs.getFloat("tarifmndf"),
				
				rs.getInt("specialisation")
				);
	}
	
};

@Repository
public class GrouptarifsJDBC implements GrouptarifsDAO {
	private static final Logger logger = Logger.getLogger(GrouptarifsJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO grouptarifs "
			+ "(idsociete, groupe, libelle, "
			+ "tarifjour, tarifnuit, tarifjdf, tarifndf,  "
			+ "tarifmj, tarifmn, tarifmjdf, tarifmndf, "
			+ "specialisation) VALUES "
			+ "(?, ?, ?,  "
			+ "?, ?, ?, ?,  "
			+ "?, ?, ?, ?,  "
			+ "? )";
	
	private static final String DELETE_QUERY = "DELETE FROM grouptarifs WHERE groupe=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE grouptarifs SET "
			+ "libelle=?, "
			+ "tarifjour=?, tarifnuit=?, tarifjdf=?, tarifndf=?,  "
			+ "tarifmj=?, tarifmn=?, tarifmjdf=?, tarifmndf=?, "
			+ "specialisation=? "
			+ " WHERE groupe=? AND idsociete=?";
	
	private static final String _QUERY_ONCE_ = "SELECT * FROM grouptarifs WHERE groupe=";
	private static final String _SELECT_ALL_ = "SELECT * FROM grouptarifs WHERE idsociete=";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean create(Grouptarifs t) {
		
		if (read().contains(t))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				t.getIdsociete(), t.getGroupe(), t.getLibelle(),
				t.getTarifjour(), t.getTarifnuit(), t.getTarifjdf(), t.getTarifndf(),
				t.getTarifmj(), t.getTarifmn(), t.getTarifmjdf(), t.getTarifmndf(),
				t.getSpecialisation()
		});
		
		logger.info("create()" + t.toString());
		return res > 0;
	}

	@Override
	public List<Grouptarifs> read() {
		logger.info("read()");
		return jdbcTemplate.query(
				_SELECT_ALL_ + "'" + SecurityCommon.retrieveLoggedUserSociete() + "'" , 
				new GrouptarifsMapper());
	}

	@Override
	public Grouptarifs search(String groupe) {
		final String SQL_QUERY = _QUERY_ONCE_ + "'"+groupe+"'" + 
				" AND idsociete='" + SecurityCommon.retrieveLoggedUserSociete() + "'"; 
		
		List<Grouptarifs> famservs = jdbcTemplate.query(SQL_QUERY, new GrouptarifsMapper());
		Grouptarifs result = famservs.get(0);
		
		logger.info("read(" + groupe + ") -> " + result.toString());
		return result;
	}

	@Override
	public boolean update(Grouptarifs t) {
		int res = jdbcTemplate.update(UPDATE_QUERY, new Object[] {
				t.getLibelle(),
				t.getTarifjour(), t.getTarifnuit(), t.getTarifjdf(), t.getTarifndf(),
				t.getTarifmj(), t.getTarifmn(), t.getTarifmjdf(), t.getTarifmndf(),
				t.getSpecialisation(), t.getGroupe(), t.getIdsociete()
		});
		
		logger.info("update()" + t.toString());
		return res > 0;
	}

	@Override
	public boolean delete(Grouptarifs t) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] {
				t.getGroupe(), t.getIdsociete()
		});
		
		logger.info("delete()" + t.toString());
		return res > 0;
	}

}
