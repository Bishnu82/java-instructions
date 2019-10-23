package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryGameApp2 {
	
	private static List<String> items = new ArrayList<>();

	public static void main(String[] args) {
		items.add("wooden staff");
		items.add("wizard hat");
		items.add("cloth shoes");
		System.out.println("Welcome to the wizard Inventory App");
		String command = "";
		while(!command.equalsIgnoreCase("exit")) {
			command = Console.getString(getDisplayMenu());
			switch (command.toLowerCase()) {
			case "show":
				//list items
				//each item on its own line
				//prefix with index # +1
				for(int i=0; i<items.size(); i++) {
					System.out.println((i+1)+" "+items.get(i));
				}
				break;
			case "grab":
				//add items
				if (items.size()>3) {
					System.out.println("You can't carry any more items. Drop something first.");
				}
				else {
					String item = Console.getString("Name:  ");
					items.add(item);
					System.out.println(item + " was added.");
				}
				break;
			case "edit":
				//edit items
				String item = getItem();
				String updItem = Console.getString("Updated name:  ");
				int idx = items.indexOf(item);
				items.set(idx,  updItem);
				System.out.println("Item number "+(idx+1)+ " was updated.");
				break;
			case "drop":
				//delete items
				item = getItem();
				items.remove(items);
				System.out.println(item+" was dropped.");
				break;
			case "exit":
				//exit app
				break;
			default:
				System.out.println("Invalid command.  Try again.");
				break;
			}
		}
	
		System.out.println("Bye");
	
	}
	
	// prompt user for an item # and return item
	private static String getItem() {
		int itemNbr = Console.getInt("Number: ", 0, items.size()+1);
		String str = items.get(itemNbr-1);
		return str;
	}
	private static String getDisplayMenu() {
		String menu = "\nCOMMAND MENU\r\n" + 
				"show - Show all items\r\n" + 
				"grab - Grab an item\r\n" + 
				"edit - Edit an item\r\n" + 
				"drop - Drop an item\r\n" + 
				"exit - Exit program \n"+
				"\n"+
				"Command:";		
		return menu;
	}

}