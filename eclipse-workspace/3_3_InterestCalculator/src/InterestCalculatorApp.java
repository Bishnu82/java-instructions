import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Interest Calculator");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			
			System.out.println("Enter Loan Ammount:   ");
			BigDecimal ammount = sc.nextBigDecimal()
				.setScale(2, RoundingMode.HALF_UP);
			System.out.println("Enter Interest Ammount:   ");
			BigDecimal iAmmount = sc.nextBigDecimal();
			BigDecimal iTotal = ammount.multiply(iAmmount)
				.setScale(2, RoundingMode.HALF_UP);
				
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);
            			
			System.out.println("Loan Ammount:        "+currency.format(ammount));
			System.out.println("Interest Rate:       "+percent.format(iAmmount));
			System.out.println("Interest:            "+iTotal);
		
			
			
			System.out.println("Continue? y/n ");
			choice = sc.next();
		
			

		}
			sc.close();
			System.out.println("Bye!");
	}
	
	
}
