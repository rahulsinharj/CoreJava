package java8Features.streamApi.map;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamApi_Reduce {		// reduce(U identity, BiFunction<U,?super T,U> accumulator, BinaryOperator<U> combiner)

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);
		
		int nsum = numbers.stream().mapToInt(i->i).sum();
		System.out.println("nsum : "+nsum);
		
		
		Integer reduceSum = numbers.stream().reduce(0, (a,b) -> a+b);			// returning the resultant (a+b)			
		System.out.println("reduceSum : "+reduceSum);
		
		
		Optional<Integer> reduceSumWithMethodRef= numbers.stream().reduce(Integer::sum);
		System.out.println("reduceSumWithMethodRef : "+reduceSumWithMethodRef.get());
		
		
		Integer multiSum = numbers.stream().reduce(1, (a,b) -> a*b);			// returning the resultant (a*b)
		System.out.println("multiSum : "+multiSum);
		
		
		Integer maxSum = numbers.stream().reduce(0, (a,b) -> a>b ? a:b);		// returning the resultant (either a or b)
		System.out.println("maxSum : "+maxSum);

		
		Integer maxSumWithMethodRef = numbers.stream().reduce(Integer::max).get();
		System.out.println("maxSumWithMethodRef : "+maxSumWithMethodRef);
		
		
//=================================================
		
		List<String> words = Arrays.asList("coreJava", "spring", "hibernate", "javascript");
		
		String longestWord = words.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2).get();	// returning the resultant (either word1, or word2)     
		System.out.println("longestWord : "+longestWord);

		
		
	}
}
