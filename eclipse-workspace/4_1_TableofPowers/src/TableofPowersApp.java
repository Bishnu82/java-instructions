import java.util.Scanner;

public class TableofPowersApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Square and Cubes table");
		int integer = 0;
		int counter = 0;
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter an integer:   ");
			integer = sc.nextInt();
			while (integer >= counter) {
				
			
			
			// initialize the table variable
            String table = "";
            
            // create header row and add it to the table
            String headerRow = "Number\t";
            for (int squared = 5; squared < 7; squared += 1) {
                headerRow += (counter*counter) + "\t\t";
            }
            table += headerRow + "\n";
            counter++;
		}
		}
	sc.close();	
	}

}
