package db;

import java.sql.*;


public class BaseDB {
	
	protected static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, username, pwd);
		return conn;
	}
	 
	
}