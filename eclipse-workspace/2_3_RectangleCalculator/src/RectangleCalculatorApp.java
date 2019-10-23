import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Rectangle Calculator");
		Scanner sc = new Scanner(System.in);
		double length;
		double width;
		double area;
		double perimeter;
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y"))  {
			
			System.out.println("Enter length: ");
			length = sc.nextDouble();
			System.out.println("Enter width:  ");
			width = sc.nextDouble();
			
			area = width*length;
			perimeter = 2*width+2*length;
			
			System.out.println("Area:           "+area);
			System.out.println("Perimeter:      "+perimeter);
			System.out.println("Continue?  y/n: ");
			choice = sc.next();
			
		}
		System.out.println("GoodBye");
	}

}
