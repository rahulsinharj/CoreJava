package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorStudent {

	public static void main(String[] args) {
		
		List<Student> studs = new ArrayList<>();
		studs.add(new Student(101,55));
		studs.add(new Student(102,95));
		studs.add(new Student(103,35));
		studs.add(new Student(104,45));
		studs.add(new Student(105,85));
		
/* We will use Comparator<> when we have a class "Student"	which is not implementing Comparable<> , 
  		in that case we can provide our comparing/sorting Logic by providing implementation of Comparator<Student>  
 
 * Or even if our "Student" class is already implementing Comparator<> , and after if we want to change the sorting logic, then better to provide our own implementation through Comparable<>		*/		
		
//		Comparator<Student> comp = new Comparator<Student>() 
//		{
//			@Override												// Using Anonymous inner class implementation
//			public int compare(Student s1, Student s2) 
//			{
//				return s1.marks > s2.marks ? -1 : (s1.marks < s2.marks ? 1 : 0);
//			}
//		};
//		Collections.sort(studs, comp);
		
		
		Collections.sort(studs, (s1,s2) -> {									// Using Lambda inner implementation
//			return s1.marks > s2.marks ? -1 : s1.marks < s2.marks ? 1 : 0;		// Sorting based on marks - Descending order
			return s2.marks - s1.marks;
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
