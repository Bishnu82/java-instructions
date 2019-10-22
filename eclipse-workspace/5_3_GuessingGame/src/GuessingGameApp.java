import java.util.Scanner;

public class GuessingGameApp {

	private static void displayWelcome(int limit) {
		System.out.println("Welcome to the Guess the Number Game!!!");
		System.out.println("I'm thinking of a number from 1 to " + limit);
		System.out.println();
	}

	private static String getString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		// keep prompting until user enters y or n
		while (!isValid) {
			System.out.println(prompt);
			s = sc.nextLine();
		// check empty string
			if (s.equalsIgnoreCase("")) {
				System.out.println("Error... entry is required");
				continue;
			}
			else if (!s.equalsIgnoreCase("y")||!s.equalsIgnoreCase("n")) {
				System.out.println("Error... only 'y' or 'n' is accepted.");
				continue;
			}
			isValid = true;
		}
		return s;
	}
	
	public static int getRandomInt(int limit) {
		double d = Math.random() * limit; // d is >= 0.0 and < limit
		int randomInt = (int) d; // convert double to int
		randomInt++; // int is >= 1 and <= limit
		return randomInt;
	}

	public static void main(String[] args) {
		final int LIMIT = 100;

		displayWelcome(LIMIT);
		int number = getRandomInt(LIMIT);

		Scanner sc = new Scanner(System.in);
		int count = 1;
		while (true) {
			System.out.print("Your guess: ");
			
			int guess = 0;

			if (sc.hasNextInt()) {
				guess = sc.nextInt();
				sc.nextLine();
			} else {
				System.out.println("Error! Invalid number. Try again.");
				sc.nextLine();
				continue;
			}

			if (guess < 1 || guess > LIMIT) {
				System.out.println("Invalid guess. Try again.");
				continue;
			}
// If (a <= (b -10)) “Way too low!”
//			If (a <= b) “Too low!”
	
			if (guess <=(number-10)) {
				System.out.println("Way Too low.");
			} else if (guess >=(number+10)) {
				System.out.println("Way Too High.");
			} else if (guess < number) {
				System.out.println("Too Low.");
			} else if (guess > number) {
				System.out.println("Too high.");
			} else if (count <= 3) {
				System.out.println("Great Work you are a mathmatical wizard " + count + " tries.\n");
			} else if (count <=7) {
				System.out.println("Not to bad you have some potential " + count + " tries.\n");
			} else if (count >7) {
				System.out.println("What took so long you should take some lessons " + count + " tries.\n");
				
				break;
			}
			count++;
		}
		System.out.println("Bye!");
	}
}
