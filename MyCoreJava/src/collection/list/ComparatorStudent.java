package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorStudent {

	public static void main(String[] args) {
		
		List<Student> studs = new ArrayList<>();
		studs.add(new Student(101,55));
		studs.add(new Student(102,95));
		studs.add(new Student(103,35));
		studs.add(new Student(104,45));
		studs.add(new Student(105,85));
		
		
		Collections.sort(studs, (s1,s2)->{
			return s1.marks > s2.marks ? -1 : s1.marks < s2.marks ? 1 : 0;
		});
		
		
		for(Student s : studs)
		{
			System.out.println(s);
		}
		
	}
}

class Student
{
	int rollno;
	int marks;
	
	public Student(int rollno, int marks) {
		super();
		this.rollno = rollno;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", marks=" + marks + "]";
	}
	
}
