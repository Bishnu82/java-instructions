package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import business.Contact;
import business.TestContact;
import util.Console;

public class ContactManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact Manager App\n");
		int command = 0;
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		while(command != 9) {
			command = Console.getInt(getMenu(), 0, 100);
			switch (command) {
			case 1:
				//List Contact
				System.out.println("List all Contacts");
				for(Contact c: contacts) {
					System.out.println(c);
				}
				break;
		    case 2:
				//List Contact no phone
				System.out.println("List Contacts no phone");
				List<Contact> contactsWithoutPhone = filterContactsWithoutPhoneNumbers(contacts);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c);
					}
				
				break;
			case 3:
				//List Contact no email
				System.out.println("List Contacts no email");
				List<Contact> contactsWithoutEmail = filterContactsWithoutEmail(contacts);
				for (Contact c : contactsWithoutEmail) {
					System.out.println(c);

					
				}
				break;
			case 4:
				//Lamda List Contact no phone
				System.out.println("List Contacts no phone");
				contactsWithoutPhone = filterContacts(contacts, c -> c.getPhone()==null);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c);
				}
				break;
			case 5:
				//Lamda List Contact no email
				System.out.println("List Contacts no email");
				contactsWithoutEmail = filterContacts(contacts, c -> c.getEmail()==null);
				for (Contact c : contactsWithoutEmail) {
					System.out.println(c);
				}
				break;
			case 6:
				//Lamda List Contact mike murach
				System.out.println("List Contacts named Mike Murach:");
				List<Contact>contactsMike = filterContacts(contacts, c -> c.getName().contentEquals("Mike Murach"));
				for (Contact c : contactsMike) {
					System.out.println(c);
				}
				break;
			case 7:
				//Lamda List Contact no phone
				System.out.println("List Contacts no phone");
				contactsWithoutPhone = filterContacts2(contacts, c -> c.getPhone()==null);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c);
				}
				break;
			case 8:
				//Lamda Consumer
				System.out.println("Lamda: Consumer: Print name");
				processContacts(contacts, c -> System.out.println(c.getName()));
				break;
			case 9:
				System.out.println("Streams - list namse for each contact missing phone");
				contacts.stream().filter(c-> c.getPhone()==null).forEach(c-> System.out.println(c.getName()));
				break;
			case 10:
				System.out.println("Map and reduce contacts to a single string");
				String csv = contacts.stream().map(c-> c.getName()).reduce("",(a,b)->a+b+", ");
				csv = csv.substring(0,csv.length()-2);
				System.out.println("All contacts"+csv);
			case 99:
				//Exit
				System.out.println("Exit");
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
				"1 - List Contacts:\n"+
				"2 - List Contacts with no phone #:\n"+
				"3 - List Contacts with no email:\n"+
				"4 - List Contacts with no phone #:\n"+
				"5 - List Contacts with no email:\n"+
				"6 - List Contacts named Mike:\n"+
				"7 - List Lambda Predicate Int:\n"+
				"8 - List Lambda Consumer Print Names:\n"+
				"9 - Stream of Contact Names w/ no phone:\n"+
				"10 - Map and reduce names to a single stream:\n"+
				"99 - Exit:\n"+
				"Command:  ";
		return menu;
	}
	public static List<Contact>filterContactsWithoutPhoneNumbers(List<Contact> contacts){
		
		List<Contact>contactsWithoutPhone = new ArrayList<>();
		for(Contact c: contacts) {
			if(c.getPhone()==null) {
				contactsWithoutPhone.add(c);
			}
		}
		return contactsWithoutPhone;
		}
	public static List<Contact>filterContactsWithoutEmail(List<Contact> contacts){
			
			List<Contact>contactsWithoutEmail = new ArrayList<>();
			for(Contact c: contacts) {
				if(c.getEmail()==null) {
					contactsWithoutEmail.add(c);
				}
			}
			return contactsWithoutEmail;
			}
	//make one method that can replace above 2 methods	
	public static List<Contact>filterContacts(List<Contact> contacts, TestContact condition){
		
		List<Contact>filteredContacts = new ArrayList<>();
		for(Contact c: contacts) {
			if(condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
		}
	public static List<Contact>filterContacts2(List<Contact> contacts, Predicate<Contact> condition){
			
			List<Contact>filteredContacts = new ArrayList<>();
			for(Contact c: contacts) {
				if(condition.test(c)) {
					filteredContacts.add(c);
				}
			}
			return filteredContacts;
			}
	public static void processContacts(List<Contact> contacts, Consumer<Contact> consumer) {
		for (Contact c: contacts) {
			consumer.accept(c);
		}
	}
}
