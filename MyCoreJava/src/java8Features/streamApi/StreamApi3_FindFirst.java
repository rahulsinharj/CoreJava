package java8Features.streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamApi3_FindFirst {

	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

		System.out.println(listValues.stream()
				 .filter(i ->  i%5 == 0)		// Pass only those listValues which are divisible by 5	=> 20 35 55 75
				 .map(i -> i*2)					// Multiply the resultant listValues by 2	=> 40 70 110 150
				 .findFirst());					// Answer = 40

		
	}

}
