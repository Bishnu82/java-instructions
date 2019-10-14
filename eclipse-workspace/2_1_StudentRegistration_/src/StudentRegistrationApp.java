import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Student Registration");
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String fName = sc.next();
		System.out.println("Enter last name: ");
		String lName = sc.next();
		System.out.println("Enter year of birth: ");
		Integer bYear = sc.nextInt();
		System.out.println("Welcome" + " " + fName + " " + lName + "!");
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is: " + " " + fName + "*" + bYear);

	}

}
