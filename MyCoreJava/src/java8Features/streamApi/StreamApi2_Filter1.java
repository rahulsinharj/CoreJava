package java8Features.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamApi2_Filter1 {

	public static void main(String[] args) {
	
		List<Integer> listValues = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

/*		int result = 0 ;
		
		for(int i : listValues) 
		{
			if(i%5==0) {
				result += i ;
			}
		}
		System.out.println(result);
*/		
		
//=========Using Stream API ::		filter() takes true/false value
		
		Predicate<Integer> pred = new Predicate<Integer>() 
		{
			@Override
			public boolean test(Integer i) 
			{
/*				if(i%5 == 0) 
					return true;
				else 
					return false;
*/
				return i%5 == 0;
				
			}	
		};
		System.out.println(listValues.stream().filter(pred).reduce(0, (c,e) -> c+e) );
		
		System.out.println(listValues.stream()
									 .filter(i ->  i%5 == 0)
									 .reduce(0, (c,e) -> c+e) );
	
	/*=================================================================================================
	 * After filtering listValues to pass only those which are divisible by 5 using Stream.filter() => 
				-> If we want to multiply the listValues by 2 (using Stream.map() )
				-> And then add all the final result of listValues :: 
	*/
		System.out.println(listValues.stream()
				 					 .filter(i ->  i%5 == 0)			// Pass only those listValues which are divisible by 5
				 					 .map(i -> i*2)						// Multiply the resultant listValues by 2	
				 					 .reduce(0, (c,e) -> c+e) );		// Add all numbers of resultant listValues.
	
	
	}
}
