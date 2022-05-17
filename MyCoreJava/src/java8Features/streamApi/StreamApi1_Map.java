package java8Features.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamApi1_Map {

	public static void main(String[] args) {
	
		List<Integer> listValues = Arrays.asList(1,2,3,4);
		
/*		int result = 0 ;
		
		for(int i : listValues ) 
		{
			result = result + i;
		}
		System.out.println(result);
*/

/*	We are achieving here MUTATION, because the value of result is continuously changing for 7 times.
 * 	Image how much mutation is ongoing here. Everytime you mutate a value, we cannot achieve concurrency here.
  
 *	To make our system very fast, we need to achieve concurrency here.
 * 	To achieve concurrency , we need to reduce the mutation here. 
  
	  Ques - How can we ingnore Mutation , how can we write a code without much mutation ?
	  Ans - Stream APIs.
  
 *	stream() method of List/Collection returns the object of Stream Interface.
 *	map() method of Stream interface accepts Function interface (which is a functional interface, therefore we can use here Lambda interface.)
*/
		
//======Elaborated below ::==========	
		
		Stream<Integer> s1 = listValues.stream();
//		s1.forEach(System.out::println);		// 1 2 3 4 5 6 
		
		Function<Integer, Integer> fun = new Function<Integer, Integer>() 
		{
			@Override
			public Integer apply(Integer i) {
				return i*2;
			}
		};
		
		Stream<Integer> s2 = s1.map(fun);				// 2 4 6 8 10 12
//		s2.forEach(System.out::println);
		
		BinaryOperator<Integer> bin = new BinaryOperator<Integer>() 
		{
			@Override
			public Integer apply(Integer c, Integer e) {			// c = carry ; e = value
				return c+e ;
			}
		};
		
		Integer total = (Integer)s2.reduce(0 , bin);		// firstly 0 and 2 will go inside this reduce method, and 0+2=2 will be returned; then 2 and 4 will go into this method, and returned as 2+4=6. 
		
		System.out.println(total);
	
		
//======Using Lambda Empression ::========
		
		System.out.println(listValues.stream()
									 .map(i -> i*2)
									 .reduce(0,(c,e) -> c+e) );				// Easiest & Simplest way 

		System.out.println(listValues.stream().map(i -> i*2).reduce(0,(c,e) -> Integer.sum(c, e)));

		// When using Lambda expression, Whenever you are working with a method of a class (which accepts parameter and process it and then return it), there you can use METHOD REFERENCE - as below :
		
		System.out.println(listValues.stream().map(i -> i*2).reduce(0, Integer::sum));
		
		
		
	}
}
