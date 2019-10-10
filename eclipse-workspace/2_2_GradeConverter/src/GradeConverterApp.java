import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the letter grade converter");
		Scanner sc = new Scanner(System.in);
		String userEntry = "y";
		while (userEntry.equalsIgnoreCase("Y")) {
				System.out.println("Enter numerical grade: ");
				Integer grade = sc.nextInt();
				String gLetter = null;
					if (grade >= 88) 
						gLetter = "A";
					else if (grade >= 80)
						gLetter = "B";
					else if (grade >= 67)
						gLetter = "C";
					else if (grade >= 60)
						gLetter = "D";
					else
						gLetter = "F";
					
		System.out.println("Letter Grade :" + " " + gLetter);		
		System.out.println("Continue? y/n");
		System.out.println("Good Bye !!!");
		
		sc.close();
		
		}
	}

}