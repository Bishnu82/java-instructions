import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();
           
            // convert yearly values to monthly values
          NumberFormat currency = NumberFormat.getCurrencyInstance();
          NumberFormat percent = NumberFormat.getPercentInstance();
          percent.setMinimumFractionDigits(1);
          
          
          String table = "";
          
          
          String headerRow = "Year\t";
          for (double rate = 5.0; rate < 7.0; rate += .5) {
        	  headerRow += percent.format(rate/100) + "\t\t";
          }
          table += headerRow + "\n";
            

          for (int year = 1; year <= years; year++) {
        	  
        	  String row = year + "\t";
        	  
        	  
        	  for (double rate = 5.0; rate < 7.0; rate += .5) {
        		  
        		  int months = year * 12;
        		  double monthlyInterestRate = rate / 12 / 100;
        	  
        	  
        		  double futureValue = 0.0;
        		  for (int i = 1; i <= months; i++) {
        			  futureValue = (futureValue + monthlyInvestment) *
        					  		(1 + monthlyInterestRate);
        		  }
        		  
        		  row += currency.format(futureValue) + "\t";
        	  }
        	  
        	  table += row + "\n";
          }
          System.out.println();
          System.out.println(table);
          
          // see if the user wants to continue
          System.out.print("Continue? (y/n): ");
          choice = sc.next();
          System.out.println();
        }
        System.out.println("Bye!");
    }
}