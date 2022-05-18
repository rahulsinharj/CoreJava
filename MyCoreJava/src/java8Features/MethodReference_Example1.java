package java8Features;

import java.util.Arrays;
import java.util.List;

public class MethodReference_Example1 {

	public static void main(String[] args) {
	
		List<Integer> values = Arrays.asList(1, 2, 3, 4);
		
		// When using Lambda expression, Whenever you are working with a method of a class (which accepts parameter and process it and then return it), there you can use METHOD REFERENCE - as below :
		
		values.forEach(MethodReference_Example1::doubleEach);

	}
	
	public static void doubleEach(int i)
	{
		System.out.println(i*2);
	}

}
