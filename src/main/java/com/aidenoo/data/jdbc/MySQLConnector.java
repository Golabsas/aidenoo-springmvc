package com.aidenoo.data.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

public class MySQLConnector {
	public static Logger logger = LogManager
			.getLogger(MySQLConnector.class);
	
	public Connection conn;
	
    private static class Singlteton {
        static final MySQLConnector INSTANCE = new MySQLConnector();
    }

    public static MySQLConnector getInstance(){
        return Singlteton.INSTANCE;
    }
    
	private MySQLConnector() {
		try {
			loadDriver();
			setupConnetion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setupConnetion() throws SQLException {
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/aidenous","root","");
		logger.debug("Connexion BDD Ecole OK!!");
	}
	
	private void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		logger.debug("loaddriver OK!!");
	}
	
	private void shutdownDatabase() throws SQLException {
		logger.debug("shutdown OK!!");
	}
	
	public void closeConnection() throws SQLException {
		shutdownDatabase();
		conn.close();
		logger.debug("close OK!!");
	}
}
