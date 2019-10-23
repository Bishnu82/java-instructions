package ui;

import java.util.Arrays;

import Business.Student;
import util.Console;

public class StudentScoresApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the student scores app");
		
		int nbrOfStudents = Console.getInt("\nNumber of Students: ", 0, 501);
		Student[] students = new Student[nbrOfStudents];
		for(int i=0; i<nbrOfStudents; i++) {
			System.out.println("\nStudent "+(i+1));
			String ln = Console.getString("Last name:  ");
			String fn = Console.getString("First name: ");
			int s = Console.getInt("Score: ", -1, 101);
			Student student = new Student(fn,ln,s);
			students[i]=student;
		}
		
		// biz logic
		Arrays.sort(students);
		
		System.out.println("\nSummary");
		for (Student s: students) {
			System.out.println(s);
		}
		
		System.out.println("Bye");
	}

}
