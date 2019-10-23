import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the tempuratue convertor");
		
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		
		while (choice.equalsIgnoreCase("Y")) { 
			System.out.println("Enter degrees in fahrenheit: ");
			double fahren = sc.nextDouble();
			double result = (fahren-32)*5/9;
			NumberFormat number = NumberFormat.getNumberInstance();
			number.setMaximumFractionDigits(2);
			System.out.println("Degrees in Celsius:" + " " + number.format(result));
			System.out.println("Continue (y/n)");
			choice = sc.next();
			
			
			
			
		}
		System.out.println("Goodbye");
	
	}
}