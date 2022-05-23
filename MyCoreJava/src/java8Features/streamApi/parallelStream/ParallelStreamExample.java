package java8Features.streamApi.parallelStream;

import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		
		IntStream.range(1, 1000).forEach(i ->  System.out.print(i +" "));	// You can also with with "List<Integer> iList = new ArrayList<Integer>();"
		end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("Plain stream took time : " + (end - start));

System.out.println("============================================");

		start = System.currentTimeMillis();
		IntStream.range(1, 1000).parallel().forEach(i ->  System.out.print(i +" "));	// Order of executing is not constant in parallel stream.  
		end = System.currentTimeMillis();												// But response wise Parallel is less time consuming and better than Plain Stream.  
		
		System.out.println();
		System.out.println("Parallel stream took time : " + (end - start));

		
//================================================================
System.out.println("============================================");
		
		// Plain Stream will execute in sequence wise ::
		IntStream.range(1, 10).forEach(x -> System.out.println("Thread : "+Thread.currentThread().getName()+" : "+x));

		System.out.println("============================================");
		
		// Parallel Stream will execute in non-sequentially/without any order ::
		IntStream.range(1, 10).parallel()
				 .forEach(x -> System.out.println("Thread : "+Thread.currentThread().getName()+" : "+x));
			
		
		
	}
}
