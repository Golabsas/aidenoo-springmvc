package com.aidenoo.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aidenoo.data.dao.LoginDAO;
import com.aidenoo.data.model.Login;

class LoginMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Login( rs.getString("login"), 
				rs.getString("passwordx"), 
				rs.getString("email"), 
				rs.getString("role"),
				rs.getString("id_compagnie"));
	}
}

@Repository
public class LoginJDBC implements LoginDAO {
	private static final String CREATE_QUERY = "INSERT INTO login (login, passwordx, email, role, id_compagnie) VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_QUERY = "DELETE FROM login WHERE login=?";
	private static final String UPDATE_QUERY = "UPDATE login SET passwordx=?, email=?, role=?, id_compagnie=?, WHERE login=?";
	private static final String _QUERY_ONCE_ = "SELECT * FROM LOGIN WHERE login=";
	private static final String _SELECT_ALL_ = "SELECT * FROM LOGIN";
	
	public LoginJDBC() {
		super();
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String readPassword(String login) {
		Login lg = this.read(login);
		
		if ( null == lg ) {
			return "ERROR_SQL_QUERY_PASSWORD";
		}
		
		return lg.getPasswordx();
	}	
	
	@Override
	public boolean create(Login login) {
		
		if (readAll().contains(login))
			return false;
		
		int res = jdbcTemplate.update(CREATE_QUERY, new Object[] {
				login.getLogin(), 
				login.getPasswordx(), 
				login.getEmail(),
				login.getRole(), 
				login.getCompany()
		});
				
		return res > 0;
	}

	public List<Login> readAll() {
		return jdbcTemplate.query(_SELECT_ALL_, new LoginMapper());
	}

	@Override
	public boolean update(Login login) {
		int res = jdbcTemplate.update( UPDATE_QUERY, new Object[] {  
				login.getPasswordx(), 
				login.getEmail(), 
				login.getRole(),
				login.getCompany(),
				login.getLogin()
		});
				
		return res > 0;
	}

	@Override
	public boolean delete(Login login) {
		int res = jdbcTemplate.update(DELETE_QUERY, login.getLogin());
		
		return res > 0;
	}

	@Override
	public Login read(String login) {
		final String SQL_QUERY_LOGIN = _QUERY_ONCE_ + "'"+login+"'";
		List<Login> logins = jdbcTemplate.query(SQL_QUERY_LOGIN, new LoginMapper());
		
		return logins.get(0);
	}
}
