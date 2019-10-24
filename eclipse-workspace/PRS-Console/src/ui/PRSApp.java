package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import business.User;



import util.Console;
import util.StringUtils;

public class PRSApp {
	private static DAO<User> userFile = new UserTextFile();

	public static void main(String[] args) {
	
	        System.out.println("Welcome to the PRS Console\n");
	        displayMenu();  

	        // perform 1 or more actions
	        String action = "";
	        while (!action.equalsIgnoreCase("exit")) {
	            // get the input from the user
	            action = Console.getString("Enter a command: ");
	            System.out.println();

	            if (action.equalsIgnoreCase("list")) {
	                displayAllUsers();
	            } else if (action.equalsIgnoreCase("get")) {
	                displayOneUser();
	            } else if (action.equalsIgnoreCase("add")) {
	                addUser();
	            } else if (action.equalsIgnoreCase("edit")) {
	                editUser();
	            } else if (action.equalsIgnoreCase("del") || 
	                       action.equalsIgnoreCase("delete")) {
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
	            System.out.println("list    - List all Users");
	            System.out.println("get     - Get a User");
	            System.out.println("add     - Add a User");
	            System.out.println("edit    - Edit a User");
	            System.out.println("del     - Delete a User");
	            System.out.println("exit    - Exit this application\n");
	        }
	        public static void displayAllUsers() {
	            System.out.println("User LIST");

	            List<User> users = userFile.getAll();
	            StringBuilder sb = new StringBuilder();
	            for (User u : users) {
	                sb.append(
	                        u.getId());
	                sb.append(StringUtils.padWithSpaces(
	                        u.getUserName(), 10));
	                sb.append(StringUtils.padWithSpaces(
	                        u.getPassword(), 10));
	                sb.append(StringUtils.padWithSpaces(
	                        u.getFirstName(), 10));
	                sb.append(StringUtils.padWithSpaces(
	                        u.getLastName(), 10));
	                sb.append(StringUtils.padWithSpaces(
	                        u.getPhoneNumber(), 10));
	                sb.append(StringUtils.padWithSpaces(
	                        u.getEmail(), 10));
	                sb.append(
	                        u.getIsReviewer());
	                sb.append(
	                        u.getIsAdmin());
	                sb.append("\n");
	            }
	            System.out.println(sb.toString());
	        }
	        
	        public static void displayOneUser() {
	        	int userId = Console.getInt("Which Username?");
	            System.out.println("User");
	            User user = userFile.get(userId);
	            System.out.println(user);
	        }

	        public static void addUser() {
	        	int id = Console.getInt("Enter User Id");
	            String userName = Console.getString("Enter User Name: ");
	            String password = Console.getString("Enter Password: ");
	            String firstName = Console.getString("Enter First Name: ");
	            String lastName = Console.getString("Enter Last Name: ");
	            String phoneNumber = Console.getString("Enter Phone Number: ");
	            String email = Console.getString("Enter Email: ");
	            boolean isReviewer = Boolean.parseBoolean(Console.getString("Is Reviewer: true / false "));
	            boolean isAdmin = Boolean.parseBoolean(Console.getString("Is Admin: true / false "));
	            

	            User user = new User();
	            user.setId(id);
	            user.setUserName(userName);
	            user.setPassword(password);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setPhoneNumber(phoneNumber);
	            user.setEmail(email);
	            user.setIsReviewer(isReviewer);
	            user.setIsAdmin(isAdmin);
	            userFile.add(user);

	            System.out.println(userName
	                    + " has been added.\n");
	        }
	        
	        public static void editUser() {
	        	int userId = Console.getInt("Which User would you like to edit?");
	            User user = userFile.get(userId);
	            
	            int id = Console.getInt("Enter User Id");
	            String userName = Console.getString("Enter User Name: ");
	            String password = Console.getString("Enter Password: ");
	            String firstName = Console.getString("Enter First Name: ");
	            String lastName = Console.getString("Enter Last Name: ");
	            String phoneNumber = Console.getString("Enter Phone Number: ");
	            String email = Console.getString("Enter Email: ");
	            boolean isReviewer = Boolean.parseBoolean(Console.getString("Is Reviewer: true / false "));
	            boolean isAdmin = Boolean.parseBoolean(Console.getString("Is Admin: true / false "));
	            
	            user.setId(id);
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

	            User u = userFile.get(id);
	            if (u != null) {
	                userFile.delete(u);
	                System.out.println(u.getUserName()
	                        + " has been deleted.\n");
	            } else {
	                System.out.println("No Users match that code.\n");
	            }
	        }
	    }
						
