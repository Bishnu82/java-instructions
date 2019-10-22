<<<<<<< HEAD
=======
import java.util.InputMismatchException;
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34
import java.util.Scanner;

public class GuessNumberApp {
    
    private static void displayWelcome(int limit) {
        System.out.println("Guess the number!");
        System.out.println("I'm thinking of a number from 1 to " + limit);
        System.out.println();
    }
    
    public static int getRandomInt(int limit) {
        double d = Math.random() * limit;   // d is >= 0.0 and < limit
        int randomInt = (int) d;            // convert double to int
        randomInt++;                        // int is >= 1 and <= limit
        return randomInt;
    }

    public static void main(String[] args) {
        final int LIMIT = 10;
        
        displayWelcome(LIMIT);
        int number = getRandomInt(LIMIT);

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);            
        int count = 1;
        while (true) {
<<<<<<< HEAD
            System.out.print("Your guess: ");
            int guess = sc.nextInt();
            
=======
        	System.out.print("Your guess: ");
        	int guess = 0;
        	//try {
        	//	guess = sc.nextInt();
        	//} catch(InputMismatchException e) {
            //	System.out.println("Error! Invalid number. Try again.");
            //	sc.nextLine();
            //	continue;
            //}
        	if (sc.hasNextInt()) {
                guess = sc.nextInt();
                sc.nextLine();
            } 
        	
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34
            if (guess < 1 || guess > LIMIT) {
                System.out.println("Invalid guess. Try again.");
                continue;
            }
            
            if (guess < number) {
                System.out.println("Too low.");
            } else if (guess > number) {
                System.out.println("Too high.");
            } else {
                System.out.println("You guessed it in " + 
                                   count + " tries.\n");
                break;
            }            
            count++;
<<<<<<< HEAD
        }
        System.out.println("Bye!");
    }   
}
=======
        
        }
        System.out.println("Bye!");
    }   
}
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34
