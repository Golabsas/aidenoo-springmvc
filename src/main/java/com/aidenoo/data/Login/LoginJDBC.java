package com.aidenoo.data.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class LoginMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Login( 
				rs.getString("idsociete"), 
				rs.getString("login"), 
				rs.getString("passwordx"), 
				rs.getString("email"), 
				rs.getString("role"));
	}
}

@Repository
public class LoginJDBC implements LoginDAO {
	private static final Logger logger = Logger.getLogger(LoginJDBC.class);
	
	private static final String CREATE_QUERY = "INSERT INTO login (idsociete, login, passwordx, email, role) VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM login WHERE login=? AND idsociete=?";
	private static final String UPDATE_QUERY = "UPDATE login SET passwordx=?, email=?, role=?, WHERE idsociete=? AND login=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM LOGIN WHERE login=";
	private static final String _SELECT_ALL_ = "SELECT * FROM LOGIN";
	
	public LoginJDBC() {
		super();
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String readPassword(String login) {
		Login lg = this.search(login);
		
		if ( null == lg ) {
			return "ERROR_SQL_QUERY_PASSWORD";
		}
		
		String passwordx = lg.getPasswordx();
		
		logger.info("readPassword( " + login + " ) : " + "[PROTECTED]");
		return passwordx;
	}	
	
	@Override
	public boolean create(Login login) {
		
		if (read().contains(login))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				login.getIdsociete(),
				login.getLogin(), 
				login.getPasswordx(), 
				login.getEmail(),
				login.getRole() 
		});
				
		logger.info("Create()");
		return res > 0;
	}

	public List<Login> read() {
		logger.info("read()");
		return jdbcTemplate.query(_SELECT_ALL_, new LoginMapper());
	}

	@Override
	public boolean update(Login login) {
		int res = jdbcTemplate.update( UPDATE_QUERY, new Object[] {  
				login.getPasswordx(), 
				login.getEmail(), 
				login.getRole(),
				login.getIdsociete(),
				login.getLogin()
		});
		
		logger.info("Update()");		
		return res > 0;
	}

	@Override
	public boolean delete(Login login) {
		int res = jdbcTemplate.update(DELETE_QUERY, new Object[] { 
				login.getLogin(), login.getIdsociete() 
		});
		
		logger.info("Delete()");
		return res > 0;
	}

	@Override
	public Login search(String login) {
		final String SQL_QUERY_LOGIN = _QUERY_ONCE_ + "'"+login+"'";
		
		List<Login> logins = jdbcTemplate.query(SQL_QUERY_LOGIN, new LoginMapper());
		
		logger.info("search( " + login + " )");
		return logins.get(0);
	}

	@Override
	public String readSociete(String login) {
		Login lg = this.search(login);
		
		if ( null == lg ) {
			return "ERROR_SQL_QUERY_SOCIETY";
		}
		
		String idsociete = lg.getIdsociete();
		
		logger.info("readSociete( " + login + " ) : " + idsociete);
		return idsociete;
	}
}
