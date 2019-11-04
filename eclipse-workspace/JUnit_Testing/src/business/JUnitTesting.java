package business;

import util.Console;

public class JUnitTesting {
	
//	int square(int nbr):  accepts an int and returns the int squared
//	+ int countA(String str):  accepts a String and returns an int
//	  representing the number of times the letter 'a' occurs (either lower or upper case)
	
	public static int square(int nbr) {
		int square = (int) Math.pow(nbr, 2);
		return nbr;
	}
	
	public static int countA(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='a' || str.charAt(i) == 'A') {
				count++;
			}
		
		}

		System.out.printf("There are %d uppercase letters and %d lowercase letters.",count);
	}
	
	
}
