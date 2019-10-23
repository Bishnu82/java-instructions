

import java.util.Scanner;

public class NameParserApp {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.println();
        int index = name.indexOf(" ");
        String firstName = name.substring(0,index);
        String lastName =name.substring(index+1);
        System.out.println("First Name: "+firstName);
        System.out.println("Last Name: "+lastName);
        
    }
}
