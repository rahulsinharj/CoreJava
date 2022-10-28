package java8Features.streamApi.sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Find3rdLargest_SortList {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4,5,7,3,2,6));
		
//		list.stream().sorted((e1,e2) -> e2 - e1 ).forEach(System.out::println);		// [ 7 , 6 , 5 , 4 , 3 , 2 ]
	
		int ans = list.stream()
					  .sorted(Comparator.reverseOrder())
					  .skip(2)
					  .findFirst()
					  .get();
								

		System.out.println(ans);
	
	
	
	}
}
