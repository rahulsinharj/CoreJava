package miscellaneous;

import java.util.Arrays; 

public class ComparableDemo implements Comparable<ComparableDemo> {  
	// Java Program to show how to override the compareTo() method of comparable interface implementing Comparable interface 

		String name; 
		int age; 
		
		// Class constructor 
		ComparableDemo(String name, int age) 
		{ 
			this.name = name; 
			this.age = age; 
		} 
	
		public static void main(String[] args) 
		{ 
			// Creating GFG class object 
			ComparableDemo ob[] = new ComparableDemo[4]; 
			
			// Inserting elements in the objects 
			ob[0] = new ComparableDemo("Mohit", 20); 
			ob[1] = new ComparableDemo("Aayush", 12); 
			ob[2] = new ComparableDemo("Ravi", 14); 
			ob[3] = new ComparableDemo("Sachin", 19); 
			
			
			// sort the array,using overridden method 
			Arrays.sort(ob); 

			for (ComparableDemo o : ob) { 
				
				// printing the sorted array objects name and age 
				System.out.println(o.name + " " + o.age); 
			} 
		} 
		// Overriding compareTo() method 
		@Override public int compareTo(ComparableDemo o) 
		{ 
//			if (this.age > o.age) { 
//				
//				// if current object is greater,then return 1 
//				return 1; 
//			} 
//			else if (this.age < o.age) { 
//				
//				// if current object is greater,then return -1 
//				return -1; 
//			} 
//			else { 
//				
//				// if current object is equal to o,then return 0 
//				return 0; 
//			} 
			
			return this.age-o.age;
		} 
	}
