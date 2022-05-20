package collection.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		
		int num = 5;
		
		List values = new ArrayList();
		
		values.add(num);
		values.add("Rahul");		// Here both Integer(5) and String("Rahul") both are here supported in the same list.
									// That means we are not achieving Type Safety here.
		
		// Below is the Syntax we have to use to achieve Type Safety
		
		List<Integer> intValues = new ArrayList<>();
		
		intValues.add(num);
		intValues.add(7);
//		intValues.add("Rahul");			// This line will give compile time error - for achieving Type Safety
		
		
	}

}
