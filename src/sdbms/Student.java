package sdbms;

public class Student {
	
	//4 Private Data Members -> id, age, name, marks
	private String id;
	private int age;
	private String name;
	private int marks;
	
	static int count=101;
	
	// Constructor
	Student(int age, String name,int marks){
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}
	//3setter methods & 4 getter methods
	
	public String getId() {
		return id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	
	
	//toString() ->
	@Override
	public String toString() {
		return "id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks ;
	}


	
	
	
	
}
