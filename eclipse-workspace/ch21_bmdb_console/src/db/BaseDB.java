package db;

import java.sql.*;


public class BaseDB {
	
	protected static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "bmdb_user";
		String pwd = "seasame";
		Connection conn = DriverManager.getConnection(dbURL, username, pwd);
		return conn;
	}
	 
	
}