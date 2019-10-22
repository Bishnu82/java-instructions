import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Change Calculator");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		
		while (choice.equalsIgnoreCase("y")) {
			int qCounter = 0;
			int dCounter = 0;
			int nCounter = 0;
			int pCounter = 0;
		System.out.println("Enter number of cents (0-99):  ");
			int cents = sc.nextInt();
			while (cents >= 25) {
				int total = (cents-25);
				cents = total;
				qCounter++;
				}
			
			while (cents >= 10) {
				int total = (cents-10);
				cents = total;
				dCounter++;
				}
			
			while (cents >= 5) {
				int total = (cents-5);
				cents = total;
				nCounter++;
				}
			
			while (cents >= 1) {
				int total = (cents-1);
				cents = total;
				pCounter++;
				}		
		
		System.out.println("Quarters:     "+qCounter);
		System.out.println("Dime:         "+dCounter);
		System.out.println("Nickel:       "+nCounter);
		System.out.println("Penny:        "+pCounter);
		System.out.println("Continue:  y/n");
		choice = sc.next();
		
				
		}
		sc.close();
		System.out.println("Goodbye");
	}	
}
