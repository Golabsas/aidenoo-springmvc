package com.aidenoo.data.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Repository;

import com.aidenoo.data.jdbc.MySQLConnector;

class LoginMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Login( rs.getString("login"), 
				rs.getString("passwordx"), 
				rs.getString("emil"), 
				rs.getString("role"),
				rs.getString("id_compagnie"));
	}
}

@Primary
@Repository
public class LoginJDBC implements LoginDAO {
	private static final String INSERT_LOGIN_QUERY = "INSERT INTO login (login, passwordx, question, reponse) VALUES(?, ?, ?, ?)";
	private static final String DELETE_LOGIN_QUERY = "DELETE FROM login WHERE login=?";
	private static final String UPDATE_LOGIN_QUERY = "UPDATE login SET passwordx=?, question=?, reponse=? WHERE login=?";
	private static final String QUERY_ONE_LOGIN = "SELECT * FROM LOGIN WHERE login=";
	private static final String QUERY_LOGINS = "SELECT * FROM LOGIN";
	
	public LoginJDBC() {
		super();
	}
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(
			new SingleConnectionDataSource(MySQLConnector.getInstance().conn, false));
		

	public String readPassword(String login) {
		final String SQL_QUERY_LOGIN = QUERY_ONE_LOGIN + "'"+login+"'";
		List<Login> pwds = jdbcTemplate.query(SQL_QUERY_LOGIN , new LoginMapper());
		
		String result="ERROR_SQL_QUERY_LOGIN";
		
		if (!pwds.isEmpty()) {
			result = pwds.get(0).getPasswordx();
		}	
		
		return result; 
	}	
	
	public void close() {
		try {
			MySQLConnector.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Login login) {
		
		if (readAll().contains(login))
			return false;
		
		int res = jdbcTemplate.update(INSERT_LOGIN_QUERY, new Object[] {
				login.getLogin(), 
				login.getPasswordx(), 
				login.getEmail(),
				login.getRole(), 
				login.getCompany()
		});
				
		return (res > 0);
	}

	public List<Login> readAll() {
		return jdbcTemplate.query(QUERY_LOGINS, new LoginMapper());
	}

	public boolean update(Login login) {
		int res = jdbcTemplate.update( UPDATE_LOGIN_QUERY, new Object[] {  
				login.getPasswordx(), 
				login.getEmail(), 
				login.getRole(),
				login.getCompany(),
				login.getLogin()
		});
				
		return (res > 0);
	}

	public boolean delete(Login login) {
		int res = jdbcTemplate.update(DELETE_LOGIN_QUERY, login.getLogin());
		
		return (res > 0);
	}
}
