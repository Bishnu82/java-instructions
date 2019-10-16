public class Console {

	public Contact getContact(String contact) {
	        // In a more realistic application, this code would
	        // get the data for the product from a file or database
	        // For now, this code just uses if/else statements
	        // to return the correct product data

	        // create the Product object
	        Contact contact;

	        // fill the Product object with data
	        if (name.equalsIgnoreCase("java")) {
	            product = new Product(productCode, "Murach's Java Programming", 57.50);
	        } else if (productCode.equalsIgnoreCase("jsp")) {
	            product = new Product(productCode, "Murach's Java Servlets and JSP", 57.50);
	        } else if (productCode.equalsIgnoreCase("mysql")) {
	            product = new Product(productCode, "Murach's MySQL", 54.50);
	        } else if (productCode.equalsIgnoreCase("andr")) {
	            product = new Product(productCode, "Murach's Android Programming", 57.50);

	        } else {
	            product = new Product(productCode, "Unknown", 0);
	        }
	        return product;
	    }

}
