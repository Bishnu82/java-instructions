package db;

import java.sql.*;

import business.Stuffy;

public class StuffyDB {
	
	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/stuffy_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "stuffy_user";
		String pwd = "seasame";
		Connection conn = DriverManager.getConnection(dbURL, username, pwd);
		return conn;
	}
	 
	public Stuffy get(int id) {
		String sql = "select * from stuffy where id = "+id;
		Stuffy s = null;
		try(Statement stmt = getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			boolean stuffyExists = rs.next();
			if(stuffyExists) {
				// result set as a stuffy
				//process the result set row
				int id2 = rs.getInt(1);
				String type = rs.getString(2);
				String color = rs.getString(3);
				String size = rs.getString(4);
				int limbs = rs.getInt(5);
				s = new Stuffy(id2, type, color, size, limbs);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public int add(Stuffy s) {
		int rowCount = 0;
		String sql = "Insert into Stuffy (Type, Color, Size, Limbs) "+
					"Values (?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1,  s.getType());
			ps.setString(2,  s.getColor());
			ps.setString(3,  s.getSize());
			ps.setInt(4,  s.getLimbs());
			rowCount = ps.executeUpdate();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		
		return rowCount;
	}
	
	public static void list(Stuffy s) throws SQLException {
		String sql = "select * from stuffy";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		System.out.println(ps);
				

		}
}