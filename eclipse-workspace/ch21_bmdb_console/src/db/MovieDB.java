package db;

import java.sql.*;
import java.util.*;

import business.Movie;

public class MovieDB extends BaseDB {
	
	public List<Movie> list(){
		List<Movie> movieList = new ArrayList<>();
		String sql = "select * from movie";
		try(PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {   //keeps getting info while its not null
				Movie m = getmoviefromresultset(rs);
				movieList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	public Movie get(int id){
		Movie movie = null;
		String sql = "select * from movie where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {   //keeps getting info while its not null
				movie = getmoviefromresultset(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movie;
		
	}
	
	public int add(Movie m) {
		int rowCount = 0;
		String sql = "insert into Movie (title, rating, year, director)	values"+
				"(?, ?, ?, ?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1, m.getTitle());
			ps.setString(2, m.getRating());
			ps.setInt(3, m.getYear());
			ps.setString(4, m.getDirector());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int update (Movie m) {
		int rowCount = 0;
		String sql = "update Movie set year = ? where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, m.getYear());
			ps.setInt(2, m.getId());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int delete(Movie m) {
		int rowCount = 0;
		String sql = "delete from Movie where id = ?";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, m.getId());
			rowCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	private Movie getmoviefromresultset(ResultSet rs) throws SQLException {
		// Get a movie form the result set
		int id = rs.getInt(1);
		String title = rs.getString(2);
		String rating = rs.getString(3);
		int year = rs.getInt(4);
		String director = rs.getString(5);
		Movie m = new Movie(id, title, rating, year, director);
		return m;
	}
}
