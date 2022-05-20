package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyList {

	public static void main(String[] args) {
		
/*	=> Working with Collection<> interface :: 
 	===============================================*/	
/*		Collection<Integer> clist = new ArrayList<>();	// List maintains the insertion order
		clist.add(3);
		clist.add(6);
		clist.add(7);

		clist.add(1,4);			// We can't add element in between List through Collection<> interface ; For adding element in between List<> interface will only work.  
											
		System.out.println(clist);
		
		Collections.sort(clist);	// The method sort(List<T>) in the type Collections is not applicable for the arguments (Collection<Integer>)	
									// Collections.sort() does not accepts Collection<> interface reference ; only accepts List<> interface reference
*/	
		
/*	=> Working with List<> interface :: 
 	===============================================*/		
		List<Integer> mylist = new ArrayList<>();	// List maintains the insertion order
		mylist.add(8);
		mylist.add(4);
		mylist.add(3);
		mylist.add(9);
		
		mylist.add(1, 5);					// Adding values in between through List<> interface
		System.out.println(mylist);
		
		Collections.sort(mylist);			// Sorting elements of List<> interface	
		System.out.println(mylist);
	 
		Collections.reverse(mylist);		// Reverse-Sorting elements of List<> interface	
		System.out.println(mylist);
	 
//		mylist.forEach(System.out::println);
	
		
		
	}
}
