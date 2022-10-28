package java8Features.streamApi.sorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

//	SORTING PREMITIVE DATATYPES ::
public class SortLIST_Primitive {			

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<Integer>();	// [8, 3, 12, 4]
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);
		
		int intMin = list.stream().mapToInt(i->i).min().getAsInt();		// Finding min value
		System.out.println(intMin);
		
		
		Collections.sort(list);				// [3, 4, 8, 12]
		System.out.println(list);

//		Collections.sort(list, Collections.reverseOrder());			// Reverse Sort
//		System.out.println(list);

		Collections.reverse(list);			// It will just not reverseSort, but only reverse the PREVIOUS list => [4, 12, 3, 8]
		System.out.println(list);
		
		
		list.stream().sorted().forEach(s -> System.out.print(s +" "));			// 3 4 8 12  
		
		System.out.println();
//		list.stream().sorted((a1, a2) -> a2 - a1).forEach(System.out::print);		// sorted((a1, a2) -> a2 - a1) ; sort using our custom logic.   
		
		
		// REVERSE ORDER Sorting ::
//		list.stream().sorted(Collections.reverseOrder()).forEach(s -> System.out.print(s +" "));	// 12 8 4 3 
		list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s +" "));		// 12 8 4 3 
		
		
	}

}
