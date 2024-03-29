import java.util.Scanner;

public class ContactListApp {

	public static void main(String[] args) {
		// display a welcome message
        System.out.println("Welcome to the Contact List");
        System.out.println();

        // display 1 or more products
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter first name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Enter last name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.next(); 
            sc.nextLine();  
            System.out.print("Enter phone number: ");
            String phone = sc.next(); 
            sc.nextLine();

            // get the Product object
            ProductDB db = new ProductDB();
            Product product = db.getProduct(productCode);

            // display the output
            System.out.println();
            System.out.println("SELECTED PRODUCT");
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price:       " + product.getPriceNumberFormat());
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }	
	}

}
