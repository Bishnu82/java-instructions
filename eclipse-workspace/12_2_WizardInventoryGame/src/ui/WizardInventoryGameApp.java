package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Console;

public class WizardInventoryGameApp {

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory game\n");
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item  ");
		System.out.println("edit - Edit an item  ");
		System.out.println("drop - Drop an item  ");
		System.out.println("exit - Exit program\n");
						
		List<String> inv = new ArrayList<>(4);
		inv.add("wooden staff");
		inv.add("wizard hat");
		inv.add("cloth shoes");
				
		while(true) {
		String cmd = Console.getString("Command :  ");
		System.out.println();
		int size = inv.size();
		
			if(cmd.equalsIgnoreCase("show")) {
				int x = 0;
				for (String inventory: inv) {
					System.out.println((x+1)+"."+" "+inventory);
					x++;}
					System.out.println();
				}
				
			if (cmd.equalsIgnoreCase("grab") && size<=3) {
				System.out.println("Name: potion of invisibilaty");
				System.out.println("potion of invisibility was added\n");
				inv.add("potion of invisibility");
				
			} 
			if (cmd.equalsIgnoreCase("grab") && size>3) {
				System.out.println("You can't carry any more items. Drop something first.");
			}
			
				
			if (cmd.equalsIgnoreCase("edit")) {
				int number = Console.getInt("Number: ");
				String name = Console.getString("Updated Name:  ");
				int i = number-1;
				inv.set(i, name);
				System.out.println("Item number"+" "+number+" "+"was updated");
				System.out.println();
			}
		
			if (cmd.equalsIgnoreCase("drop")) { 
				int number = Console.getInt("Number: ");
				System.out.println(inv.get(number-1)+" "+"was dropped.");
				inv.remove(number-1);
				System.out.println();
			}
			if (cmd.equalsIgnoreCase("exit")) {
				System.out.println("Bye!");
				break;
			}
		}
	}
}