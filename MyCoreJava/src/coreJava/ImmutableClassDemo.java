package coreJava;					//Java Program to Create An Immutable Class

import java.util.HashMap;
import java.util.Map;

//Class 1 : An immutable class
final class Student {						

// Member attributes of final class
	private final String name;
	private final int regNo;
	private final Map<String, String> myMap;

// Constructor of immutable class : Parameterized constructor
	public Student(String name, int regNo, Map<String, String> receivedMap) {

		// This keyword refers to current instance itself
		this.name = name;
		this.regNo = regNo;

		// Creating Map object with reference to HashMap : Declaring object of string type
		Map<String, String> tempMap = new HashMap<>();

		// Iterating using for-each loop
		for (Map.Entry<String, String> entry : receivedMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}

		this.myMap = tempMap;
	}

// Method 1
	public String getName() {
		return name;
	}

// Method 2
	public int getRegNo() {
		return regNo;
	}

// Note that there should not be any setters

// Method 3
// User-defined type : To get myMap
	public Map<String, String> getMyMap() {

		// Creating Map with HashMap reference
		Map<String, String> tempMap = new HashMap<>();

		for (Map.Entry<String, String> entry : this.myMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}

//Class 2
//Main class
public class ImmutableClassDemo {

// Main driver method
	public static void main(String[] args) {

		// Creating Map object with reference to HashMap
		Map<String, String> map = new HashMap<>();

		// Adding elements to Map object
		// using put() method
		map.put("1", "first");
		map.put("2", "second");

		Student s = new Student("ABC", 101, map);

		// Calling the above methods 1,2,3 of class1
		// inside main() method in class2 and
		// executing the print statement over them
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println(s.getMyMap());

		// Uncommenting below line causes error
//		 s.regNo = 102;				// Also we don't have any setters to set it, and also it is FINAL (even re-initialization not possible) .

		map.put("3", "third");
		// Remains unchanged due to deep copy in constructor
		System.out.println(s.getMyMap());
		s.getMyMap().put("4", "fourth");
		// Remains unchanged due to deep copy in getter
		System.out.println(s.getMyMap());
	}
}
