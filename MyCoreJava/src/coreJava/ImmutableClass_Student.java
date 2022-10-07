package coreJava;					//Java Program to Create An Immutable Class

import java.util.HashMap;
import java.util.Map;

//Class 1 : An immutable class
final class Student {						

// Member attributes of final class
	private final String studentName;
	private final int studentRegNo;
	private final Map<String, String> studentMap;

// Constructor of immutable class : Parameterized constructor
	public Student(String studentName, int studentRegNo, Map<String, String> receivedStudentMap) {

		// This keyword refers to current instance itself
		this.studentName = studentName;
		this.studentRegNo = studentRegNo;

		// Creating Map object with reference to HashMap : Declaring object of string type
		Map<String, String> tempStudentMap = new HashMap<>();

		// Iterating using for-each loop
		for (Map.Entry<String, String> entry : receivedStudentMap.entrySet()) {
			tempStudentMap.put(entry.getKey(), entry.getValue());
		}

		this.studentMap = tempStudentMap;
	}

// Method 1
	public String getStudentName() {
		return studentName;
	}

// Method 2
	public int getStudentRegNo() {
		return studentRegNo;
	}

// Note that there should not be any setters

// Method 3
// User-defined type : To get studentMap
	public Map<String, String> getStudentMap() {

		// Creating Map with HashMap reference
		Map<String, String> tempStudentMap = new HashMap<>();

		for (Map.Entry<String, String> entry : this.studentMap.entrySet()) {
			tempStudentMap.put(entry.getKey(), entry.getValue());
		}
		return tempStudentMap;
	}
}

//Class 2 : Main class
public class ImmutableClass_Student {

	public static void main(String[] args) {

		// Creating Map object with reference to HashMap
		Map<String, String> stuMap = new HashMap<>();

		// Adding elements to Map object using put() method
		stuMap.put("1", "first");
		stuMap.put("2", "second");

		Student stu = new Student("ABC", 101, stuMap);

		// Calling the above methods 1,2,3 of STUDENT class - inside main() method in Main Class and executing the print statement over them
		System.out.println(stu.getStudentName());
		System.out.println(stu.getStudentRegNo());
		System.out.println(stu.getStudentMap());

		
		// Uncommenting below line causes error
//		stu.studentRegNo = 102;							// Since Student class don't have any setters to set its properties values, and also their properties are FINAL (even re-initialization not possible) .
//		stu.studentName = "Rahul";
		
		
		stuMap.put("3", "third");								
		System.out.println(stu.getStudentMap());				// Remains unchanged due to deep copy in constructor
		
		stu.getStudentMap().put("4", "fourth");					
		System.out.println(stu.getStudentMap());				// Remains unchanged due to deep copy in constructor

		System.out.println(stu.getStudentName());				// Remains unchanged due to deep copy in getter

		
	}
}




