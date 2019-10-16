import java.util.Scanner;

public class CommonDivisorCalculatorApp2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Greatest Common Divisor App");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter number (y - greater): ");
			int y = sc.nextInt();
			System.out.println("Enter number (x - lesser): ");
			int x = sc.nextInt();
			
			while (x != 0) {
				
				while (y >= x) {
					y -= x;
			}
				int temp = x;
				x = y;
				y = temp;
			}
			System.out.println("Greatest common divisor is "+y);
			System.out.println("Continue?  ");
			choice = sc.next();
		
		}
		sc.close();
		System.out.println("Bye!!!");
		
		}
}