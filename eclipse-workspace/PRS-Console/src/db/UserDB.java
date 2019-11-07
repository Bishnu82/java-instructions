package db;

import java.sql.*;
import java.util.*;

import business.User;
import util.StringUtils;

public class UserDB extends BaseDB {
	
	public static List<User> list(){
		List<User> userList = new ArrayList<>();
		String sql = "select * from user";
		try(PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {   //keeps getting info while its not null
				User u = getuserfromresultset(rs);
				userList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	public static User get(int id){
		User user = null;
		String sql = "select * from user where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {   //keeps getting info while its not null
				user = getuserfromresultset(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public static int add(User u) {
		int rowCount = 0;
		String sql = "insert into User (userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin)"
				+ "	values" +"(?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getEmail());
			ps.setBoolean(7, u.getIsReviewer());
			ps.setBoolean(8, u.getIsAdmin());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int update (User u) {
		int rowCount = 0;
		String sql = "update User set username = ? where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUserName());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public static int delete(User u) {
		int rowCount = 0;
		String sql = "delete from User where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, u.getId());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	private static User getuserfromresultset(ResultSet rs) throws SQLException {
		// Get a user form the result set
		int id = rs.getInt(1);
		String userName = StringUtils.padWithSpaces(rs.getString(2), 10);
	    String password = StringUtils.padWithSpaces(rs.getString(3), 10);
	    String firstName = StringUtils.padWithSpaces(rs.getString(4), 10);
	    String lastName = StringUtils.padWithSpaces(rs.getString(5), 10);
	    String phoneNumber = StringUtils.padWithSpaces(rs.getString(6), 10);
	    String email = StringUtils.padWithSpaces(rs.getString(7), 10);
		boolean isReviewer = rs.getBoolean(8);
	    boolean isAdmin = rs.getBoolean(9);
		User u = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		return u;
	}
}

