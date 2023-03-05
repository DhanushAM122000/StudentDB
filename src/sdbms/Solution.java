package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {

		//Scanner
		Scanner scan=new Scanner (System.in);

		//upcasting SMS = SMSImp
		StudentManagementSystem student=new StudentManagementSystemImp();

		//While(true)
		while(true) {

			//MEANU DRIVEN PROGRAM ->1:Add STudent 2: 3...........11:Exit
			System.out.println("WELCOME TO STUDENT DB MANAGEMENT SYSTEM");
			System.out.println("---------------------------------------");
			System.out.println("1:Add Student\n2:Display Student\n3:Display All Students");
			System.out.println("4:Remove Student\n5:Remove All Students\n6:Update Student");
			System.out.println("7:Count Student\n8:Sort Student \n9:Get Student With Lowest Marks\n10:Get Student With Higest Marks");
			System.out.println("11:Exit\nEnter your Choice");

			int choice =scan.nextInt();
			switch(choice) {

			case 1:
				student.addStudent();
				break;

			case 2:
				student.displayStudent();
				break;

			case 3:
				student.displayAllStudents();
				break;

			case 4:
				student.removeStudent();
				break;

			case 5:
				student.removeAllStudents();
				break;

			case 6:
				student.updateStudent();
				break;

			case 7:
				student.countStudent();
				break;

			case 8:
				student.sortStudent();
				break;

			case 9:
				student.getStudentWithLowestMarks();
				break;

			case 10:
				student.getStudentWithHighestMarks();
				break;

			case 11:
				System.out.println("Thank You");
				System.exit(0);

			default :
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}	

			} // end of Switch

			System.out.println("---------------------------------------");
		} // end of While loop

	} // end of main()

} // end of Class



