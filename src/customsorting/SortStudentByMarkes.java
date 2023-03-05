package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByMarkes implements Comparator<Student> {

	
	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks()-y.getMarks();
	}

}
