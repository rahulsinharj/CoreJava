package java8Features.streamApi.sorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//	SORTING PREMITIVE DATATYPES ::
public class StreamApi_Sort_PrimitiveLIST {			

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<Integer>();	// [8, 3, 12, 4]
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);
		
		Collections.sort(list);				// [3, 4, 8, 12]
		System.out.println(list);

		Collections.reverse(list);			// It will just not reverseSort, but only reverse the prev list => [4, 12, 3, 8]
		System.out.println(list);
		
		
		list.stream().sorted().forEach(s -> System.out.print(s +" "));			// 3 4 8 12  
	
		// REVERSE ORDER Sorting ::
		list.stream().sorted(Collections.reverseOrder()).forEach(s -> System.out.print(s +" "));	// 12 8 4 3 
		
		
	}

}
