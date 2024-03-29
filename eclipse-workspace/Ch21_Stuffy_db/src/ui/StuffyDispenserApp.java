package ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import business.Stuffy;
import business.User;
import db.StuffyDB;
import util.Console;
import util.StringUtils;

public class StuffyDispenserApp {
	private static StuffyDB sdb = new StuffyDB();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser App");
		
		
		int command = 0;
		int id = 0;
		while(command != 6) {
			command = Console.getInt(getMenu(), 0, 7);
			switch (command) {
			case 1:
				//List
				listStuffy(id);
				break;
		        
			case 2:
				//Get
				id = Console.getInt("ID:   ");
				Stuffy s = getStuffy(id);
				
				break;
			case 3:
				//Add - prompt user for stuffy values
				String type = Console.getString("Type:  ");
				String color = Console.getString("Color:  ");
				String size = Console.getString("Size:  ");
				int limbs = Console.getInt("Limbs:  ");
				s = new Stuffy(type, color, size, limbs);
				int rowCount = sdb.add(s);
				System.out.println(rowCount+" rows affected.");
				break;
			case 4:
				//Edit
				break;
			case 5:
				//Delete
				break;
			case 6:
				//Exit
				break;
			default:
				//Error
				System.out.println("Error");
				break;
				
			
			}
		}
		
		
		
		
		
		System.out.println("Bye");
	}


	private static String getMenu() {
		String menu ="Command:\n"+
				"1 - List:\n"+
				"2 - Get:\n"+
				"3 - Add:\n"+
				"4 - Edit:\n"+
				"5 - Delete:\n"+
				"6 - Exit:\n"+
				"Command:  ";
		return menu;
	}


	private static Stuffy getStuffy(int id) {
		id = Console.getInt("ID:   ");
		Stuffy s = sdb.get(id);
		if (s!=null) {
			System.out.println("Stuffy:  ");
			System.out.println(s);
		}
		else {
			System.out.println("No stuffy exist for id:  "+id);
		}
		return s;
		}
	
	public static Stuffy listStuffy(int id) {
		int i = 1;
		Stuffy s = sdb.get(id+i);              
		while (s!=null) {
			i++;
		
       }
		return (s);
		
	}

}