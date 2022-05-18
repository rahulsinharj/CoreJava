package java8Features.streamApi.map;

import java.util.Arrays;
import java.util.List;

public class StreamApi_FindFirst {

	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

		System.out.println(listValues.stream()
									 .filter(i ->  i%5 == 0)			// Pass only those listValues which are divisible by 5	=> 20 35 55 75
									 .map(i -> i*2)						// Multiply the resultant listValues by 2	=> 40 70 110 150
									 .findFirst().orElse(0));			// Answer = 40 ;  if no ans then ans will be =0

		
	// Prof of Lazy and Eager evaluation method ::
	// filter() and  map() are very efficient methods(do not traverse the entire loop or list) , since they are Lazy evaluation methods
		
		System.out.println("===========Checking for Lazy and Eager evaluation===========");
		
		System.out.println(listValues.stream()
									 .filter(StreamApi_FindFirst::isDivisible)				// filter() is a Lazy evaluation method
									 .map(StreamApi_FindFirst::mapDouble)					// map() is a Lazy evaluation method
									 .findFirst().orElse(0));								// findFirst() is not a Lazy evaluation method , it is an Eager evaluation method or Terminal functional 

	}
	
	public static boolean isDivisible(int i) 
	{
		System.out.println("in isDivisible : "+i);
		return i%5==0 ;
	}

	public static int mapDouble(int i) 
	{
		System.out.println("in mapDouble : "+i);
		return i*2 ;
	}

}
