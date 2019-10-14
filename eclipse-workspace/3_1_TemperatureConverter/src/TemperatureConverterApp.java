import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the tempuratue convertor");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		String choice = sc.next();
		
		while (choice.equalsIgnoreCase("Y")) { 
			System.out.println("Enter degrees in fahrenheit: ");
			int fahren = sc.nextInt();
			int result = (fahren-32)*5/9;
			System.out.println("Degrees in Celsius:" + " " + result);
			System.out.println("Continue (y/n)");
			
			
			
			
		}
	}

}
