package ch02_class_demos;

public class SimpleControlStatmentsApp {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		int c = 5;
		
		if (a < b) {
			System.out.println("a less than b");
			}
		if (a==c) {
			System.out.println("a = c");
		}
		
		String s1 = "abc";
		String s2 = "abc";
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}
		
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		}
		}

}
