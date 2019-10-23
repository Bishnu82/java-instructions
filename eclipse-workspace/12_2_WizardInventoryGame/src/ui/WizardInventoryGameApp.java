package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Console;

public class WizardInventoryGameApp {

	public static void main(String[] args) {
		System.out.println("The PRS Console\n");
		System.out.println("COMMAND MENU");
		System.out.println("show - List User");
		System.out.println("get  - Get User");
		System.out.println("add - Add a user");
		System.out.println("edit - Edit user");
		System.out.println("del - Delete user");
		System.out.println("exit - Exit program\n");
						
		List<String> user = new ArrayList<>(4);
		user.add("Jon Doe");
		user.add("Will Doe");
		user.add("Jane Doe");
				
		while(true) {
		String cmd = Console.getString("Command :  ");
		System.out.println();
		int size = user.size();
		
			if(cmd.equalsIgnoreCase("show")) {
				int x = 0;
				for (String.user)) {
					System.out.println((x+1)+"."+" "+user);
					x++;}
					System.out.println();
				}
				
			if (cmd.equalsIgnoreCase("grab") && size<=3) {
				System.out.println("Name: potion of invisibilaty");
				System.out.println("potion of invisibility was added\n");
				user.add("potion of invisibility");
				
			} 
			if (cmd.equalsIgnoreCase("grab") && size>3) {
				System.out.println("You can't carry any more items. Drop something first.");
			}
			
				
			if (cmd.equalsIgnoreCase("edit")) {
				int number = Console.getInt("Number: ");
				String name = Console.getString("Updated Name:  ");
				int i = number-1;
				user.set(i, name);
				System.out.println("Item number"+" "+number+" "+"was updated");
				System.out.println();
			}
		
			if (cmd.equalsIgnoreCase("drop")) { 
				int number = Console.getInt("Number: ");
				System.out.println(user.get(number-1)+" "+"was dropped.");
				user.remove(number-1);
				System.out.println();
			}
			if (cmd.equalsIgnoreCase("exit")) {
				System.out.println("Bye!");
				break;
			}
		}
	}
}