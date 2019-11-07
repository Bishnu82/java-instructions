package ui;

import java.util.List;

import business.User;
import db.UserDB;
import util.Console;

public class PRSApp {
	//private static DAO<User> userFile = new UserTextFile();

	public static void main(String[] args) {
	
	        System.out.println("Welcome to the PRS Console\n");
	        displayMenu();  

	        String action = "";
	        while (!action.equalsIgnoreCase("exit")) {
	            action = Console.getString("Enter a command: ");
	            System.out.println();

	            if ((action.equalsIgnoreCase("list")) ||
	                (action.equalsIgnoreCase("l"))) {
	                displayAllUsers();
	            } else if (action.equalsIgnoreCase("get") ||
	                      (action.equalsIgnoreCase("g"))){
	                displayOneUser();
	            } else if (action.equalsIgnoreCase("add") ||
	            		  (action.equalsIgnoreCase("a"))){
	                addUser();
	            } else if (action.equalsIgnoreCase("edit") ||
	            		  (action.equalsIgnoreCase("e"))){
	                editUser();
	            } else if (action.equalsIgnoreCase("del") || 
	                      (action.equalsIgnoreCase("delete") ||
	             		  (action.equalsIgnoreCase("d")))){
	                deleteUser();
	            
	            } else if (action.equalsIgnoreCase("exit")) {
	                System.out.println("Bye.\n");
	            } else {
	                System.out.println("Error! Not a valid command.\n");
	            }
	        }
	}
	        private static void displayMenu() {
	            System.out.println("COMMAND MENU");
	            System.out.println("1: List    - List all Users");
	            System.out.println("2: Get     - Get a User");
	            System.out.println("3: Add     - Add a User");
	            System.out.println("4: Edit    - Edit a User");
	            System.out.println("5: Del     - Delete a User");
	            System.out.println("6: exit    - Exit this application\n");
	        }
	        public static void displayAllUsers() {
	            System.out.println("User LIST");

	            List<User> user = UserDB.list();
				System.out.println("List of movies:");
				for (User u: user) {
					System.out.println(u);
				}
			}
	            	
	        
	        public static void displayOneUser() {
	        	int userId = Console.getInt("Enter ID of User you woould like to get: ");
	            User user = UserDB.get(userId);
	            System.out.println(user);
	        }

	        public static void addUser() {
	        	//int id = Console.getInt("Enter User Id: ");
	            String userName = Console.getString("Enter User Name: ");
	            String password = Console.getString("Enter Password: ");
	            String firstName = Console.getString("Enter First Name: ");
	            String lastName = Console.getString("Enter Last Name: ");
	            String phoneNumber = Console.getString("Enter Phone Number: ");
	            String email = Console.getString("Enter Email: ");
	            boolean isReviewer = Boolean.parseBoolean(Console.getString("Is Reviewer true / false? "));
	            boolean isAdmin = Boolean.parseBoolean(Console.getString("Is Admin: true / false? "));
	            
	            User user = new User();
	            //user.setId(id);
	            user.setUserName(userName);
	            user.setPassword(password);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setPhoneNumber(phoneNumber);
	            user.setEmail(email);
	            user.setIsReviewer(isReviewer);
	            user.setIsAdmin(isAdmin);
	            UserDB.add(user);

	            System.out.println(userName
	                    + " has been added.\n");
	        }
	        
	        public static void editUser() {
	        	int userId = Console.getInt("Which User would you like to edit? ");
	            User user = UserDB.get(userId);
	            
	            //int id = Console.getInt("Enter User Id: ");
	            String userName = Console.getString("New User Name: ");
	            String password = Console.getString("New Password: ");
	            String firstName = Console.getString("New First Name: ");
	            String lastName = Console.getString("New Last Name: ");
	            String phoneNumber = Console.getString("New Phone Number: ");
	            String email = Console.getString("New Email: ");
	            boolean isReviewer = Boolean.parseBoolean(Console.getString("Is Reviewer: true / false "));
	            boolean isAdmin = Boolean.parseBoolean(Console.getString("Is Admin: true / false "));
	            
	            //user.setId(id);
	            user.setUserName(userName);
	            user.setPassword(password);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setPhoneNumber(phoneNumber);
	            user.setEmail(email);
	            user.setIsReviewer(isReviewer);
	            user.setIsAdmin(isAdmin);
	                        
	            System.out.println(user);
	        }

	        public static void deleteUser() {
	            int id = Console.getInt("Enter User ID to delete: ");

	            User u = UserDB.get(id);
	            if (u != null) {
	                UserDB.delete(u);
	                System.out.println(u.getUserName()
	                        + " has been deleted.\n");
	            } else {
	                System.out.println("No Users match that code.\n");
	            }
	        }
	    }
						
