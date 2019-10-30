package ui;

import java.util.List;

import business.Actor;
import business.Movie;
import db.ActorDB;
import db.MovieDB;
import util.Console;

public class BMDBConsoleApp {
	private static MovieDB movieDB = new MovieDB();
	private static ActorDB actorDB = new ActorDB();

	public static void main(String[] args) {
		System.out.println("bmdb Console App\n");
		
		int choice = 0;
		
		while(choice !=99) {
			choice = Console.getInt(getMenu(), 0, 100);
			switch(choice) {
			case 1:
				//list movies
				List<Movie> movies = movieDB.list();
				System.out.println("List of movies:");
				for (Movie m: movies) {
					System.out.println(m);
				}
				break;
			case 2:
				//list actors
				List<Actor> actors = actorDB.list();
				System.out.println("List of actor:");
				for (Actor a: actors) {
					System.out.println(a);
				}
				break;
			case 3:
				//add movies
				System.out.println("Add a movioe:");
				String t = Console.getString("Title?:      ");
				String r = Console.getString("Rating?:     ");
				int y = Console.getInt("Year?:       ");
				String d = Console.getString("Director?:   ");
				Movie m = new Movie(t, r, y, d);
				int rc = movieDB.add(m);
				if(rc==1) {
					System.out.println("Movie added successfully");
				}
				else {
					System.out.println("Error adding movie. check logs");
				}
				break;
			case 4:
				//update movies
				m = getMovie();
				if(m!=null) {
					int year = Console.getInt("New Year?  ");
					m.setYear(year);
					rc = movieDB.update(m);
					if(rc==1) {
						System.out.println("Movie updated succesfully!");
					}
					else {
						System.out.println("Error updating movie year.");
					}
				}
				else {
					System.out.println("Error.... movie id dosen't exist.");
				}
				break;
			case 5:
				//delete movies
				m = getMovie();
				if(m!=null) {
					rc = movieDB.delete(m);
					if(rc==1) {
						System.out.println("Movie deleted succesfully!");
					}
					else {
						System.out.println("Error deleting movie year.");
					}
				}
				else {
					System.out.println("Error.... movie id dosen't exist.");
				}
				break;
			case 6:
				//get movies
				m = getMovie();
				if(m!=null) {
					System.out.println("Movie:");
					System.out.println(m);
				}
				else {
					System.out.println();
				}
				break;
			case 7:
				//add actor
				System.out.println("Add a movie:");
				String f = Console.getString("First Name?:      ");
				String l = Console.getString("Last Name?:     ");
				String g = Console.getString("Gender?:       ");
				int b = Console.getObject("Birthdate?:   ");
				Actor a = new Actor(f, l, g, b);
				int rc2 = actorDB.add(a);
				if(rc2==1) {
					System.out.println("Movie added successfully");
				}
				else {
					System.out.println("Error adding movie. check logs");
				}
				break;
			case 8:
				//update movies
				a = getActor();
				if(a!=null) {
					String firstName = Console.getString("New First name?  ");
					a.setfName(firstName);
					rc = actorDB.update(a);
					if(rc==1) {
						System.out.println("Movie updated succesfully!");
					}
					else {
						System.out.println("Error updating movie year.");
					}
				}
				else {
					System.out.println("Error.... movie id dosen't exist.");
				}
				break;
			case 9:
				//delete movies
				a = getActor();
				if(a!=null) {
					rc = actorDB.delete(a);
					if(rc==1) {
						System.out.println("Actor deleted succesfully!");
					}
					else {
						System.out.println("Error deleting actor name.");
					}
				}
				else {
					System.out.println("Error.... actor id dosen't exist.");
				}
				break;
			case 10:
				//get movies
				a = getActor();
				if(a!=null) {
					System.out.println("Actor:");
					System.out.println(a);
				}
				else {
					System.out.println();
				}
				break;
			case 99:
				//exit
				break;
			default:
				System.out.println("Invalid Command.");
				break;
			}
		}
		
		System.out.println("Bye");
	}
	private static String getMenu() {
		String menu ="Command:\n"+
				"1  - List Movies:\n"+
				"2  - List Actors:\n"+
				"3  - Add Movie:\n"+
				"4  - Edit Movie:\n"+
				"5  - Delete Movie:\n"+
				"6  - Get Movie:\n"+
				"99 - Exit:\n"+
				"Command:  ";
		return menu;
	}
private static Movie getMovie() {
		int id = Console.getInt("ID? ", 0, Integer.MAX_VALUE);
		Movie m = movieDB.get(id);
		return m;
	}
private static Actor getActor() {
	int id = Console.getInt("ID? ", 0, Integer.MAX_VALUE);
	Actor a = actorDB.get(id);
	return a;
}
}
