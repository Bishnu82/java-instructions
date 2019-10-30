package db;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import business.Actor;

public class ActorDB extends BaseDB {
	
	public List<Actor> list(){
		List<Actor> actorList = new ArrayList<>();
		String sql = "select * from actor";
		try(PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {   //keeps getting info while its not null
				Actor a = getactorfromresultset(rs);
				actorList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;
	}
	public Actor get(int id){
		Actor actor = null;
		String sql = "select * from actor where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {   //keeps getting info while its not null
				actor = getactorfromresultset(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actor;
		
	}
	
	public int add(Actor a) {
		int rowCount = 0;
		String sql = "insert into Actor (fName, lName, gender, birthDate)	values"+
				"(?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1, a.getfName());
			ps.setString(2, a.getlName());
			ps.setString(3, a.getGender());
			ps.setDate(4, (Date) a.getBirthDate());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int update (Actor a) {
		int rowCount = 0;
		String sql = "update Movie set year = ? where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1, a.getfName());
			ps.setString(2, a.getlName());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int delete(Actor a) {
		int rowCount = 0;
		String sql = "delete from Movie where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, a.getId());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	private Actor getactorfromresultset(ResultSet rs) throws SQLException {
		// Get a movie form the result set
		int id = rs.getInt(1);
		String fName = rs.getString(2);
		String lName = rs.getString(3);
		String gender = rs.getString(4);
		Date year = rs.getDate(5);
		Actor a = new Actor(id, fName, lName, gender, year);
		return a;
	}
}

