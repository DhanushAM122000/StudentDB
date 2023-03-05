package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarkes;
import customsorting.SortStudentByName;

public class StudentManagementSystemImp implements StudentManagementSystem {

	//Scanner
	Scanner scan=new Scanner(System.in);

	//Map db=new LHM
	Map<String,Student> db=new LinkedHashMap<String, Student>();




	@Override
	public void addStudent() {
		//Accept age,name,marks
		System.out.println("Enter Student Age");
		int age=scan.nextInt();
		System.out.println("Enter Student Name");
		String name=scan.next();
		System.out.println("Enter Student Marks");
		int marks=scan.nextInt();

		//Create an Student object 
		Student std=new Student(age,name,marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Sucessfuely");
		System.out.println("Student Id is "+std.getId());


	}

	@Override
	public void displayStudent() {
		//Accept Student id
		System.out.println("Enter Student Id");
		String id=scan.next(); //String id=scan.nextLine().to
		//toUppercase()
		id=id.toUpperCase();
		//check if id is there or not ->containsKey()
		if(db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			//System.out.println(std); ->printing ref var as toString() is Overridden
		}
		else {
			try {
				//String message ="Student With the id "+id+" No Found";
				throw new StudentNotFoundException("Student With the Id "+id+" is not Found");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}


	@Override
	public void displayAllStudents() {

		if(db.size()!=0) {
			System.out.println("Student Detailes are Follows");
			System.out.println("---------------------------------------");
			//Map into Set -> KeySet()
			Set<String>keys =db.keySet();
			// for each loop to traverse Key
			for(String key :keys) {
				Student value=db.get(key);
				System.out.println(value); //System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message ="Student Record Not Avaliable to Display";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void removeStudent() {
		//Accept id and toUppercase
		System.out.println("Enter Student Id ");
		String id=scan.next();
		id=id.toUpperCase();
		//if id is present -> remove(id)
		if(db.containsKey(id)) {
			System.out.println("Student record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record Deletes Successfully");

		}
		else {
			try {
				String message="Student with the is "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}

		}
	}

	@Override
	public void removeAllStudents() {
		if(db.size()!=0) {
			System.out.println("Student Record Available: "+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully ");
			System.out.println("Student Record Available: "+db.size());

		}

		else {
			try {
				String message ="Student Database is Empty";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		//Accept id and Uppercase
		System.out.println("Enter student id");
		String id=scan.next().toUpperCase();
		//if id is present get the value (student object)
		if(db.containsKey(id)) {
			Student std=db.get(id);
			//Display 1:Update Age 2:Update name: setAge(),setName()..........

			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter your choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				std.setAge(age); //std.setAge(scan.nextInt());
				System.out.println("Student Age is updated");
				break;

			case 2:
				System.out.println("Enter Name");
				String name=scan.next();
				std.setName(name); //std.setName(scan.next());
				System.out.println("Student Name is updated");
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=scan.nextInt();
				std.setMarks(marks); //std.setMarks(scan.nextInt());
				System.out.println("Student Marks is updated");
				break;

			default :
				try {
					String message="Invalid Choice";
					throw new InvalidChoiceException(message);

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}


		else {
			try {
				String message="Student with the Id "+id+" is not Found";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudent() {

		System.out.println("No of Student Records:"+db.size());
	}

	@Override
	public void sortStudent() {
		if(db.size()>=2) {
			//Map(db) into set ->keys
			Set<String> keys=db.keySet();
			//List & ArrayList
			List <Student>list=new ArrayList<Student>();
			//for each -> Traverse key -> get the value(student object)& add it into List
			for(String  key : keys) {
				list.add(db.get(key));
			}

			//display -> SSBI, SSBA, SSBN, SSBM
			System.out.println("1:Sort By Id\n2:Sort By Age\n3:Sort By Name\n4:Sort By Markes");
			System.out.println("Enter your Choice");
			int choice=scan.nextInt();
			switch(choice) {

			case 1:
				Collections.sort(list, new SortStudentById());
				display(list);

				break;

			case 2:
				Collections.sort(list, new SortStudentByAge());
				display(list);

				break;

			case 3:
				Collections.sort(list, new SortStudentByName());
				display(list);
				break;

			case 4:
				Collections.sort(list, new SortStudentByMarkes());
				for(Student s: list) {
					System.out.println(s);
					break;
				}



			default :
				try {
					String message="Invalid Choice";
					throw new InvalidChoiceException(message);

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
		else {
			try {
				String message="No Sufficient Student Objects to Sort";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}


	private static void display(List<Student> list) {
		for(Student s: list) {
			System.out.println(s);
		}
	}


	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			//Map into KeySet
			Set<String> keys=db.keySet();
			//List ->Array List
			List<Student> l=new ArrayList<Student>();
			for(String s:keys) {
				l.add(db.get(s));
			}
			Collections.sort(l,new SortStudentByMarkes());
			System.out.println(l.get(0));
		}

		else {
			try {
				String message="No Sufficient Student Objects to Compare";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}



	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
			//Map into KeySet 
			Set<String> keys=db.keySet();
			//List ->Array List
			List<Student> l=new ArrayList<Student>();
			for(String s:keys) {
				l.add(db.get(s));
			}
			Collections.sort(l,new SortStudentByMarkes());
			System.out.println(l.get(l.size()-1));


		}
		else {
			try {
				String message="No Sufficient Student Objects to Compare";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
