package java8Features.streamApi.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi_Filter_FlatMap {			// FlatMap - takes Stream<Stream<T>> as input and return Stream<R>	=> Used for Data Transformation & Data Flattering
															// It is also called One-To-Many mapping
	public static void main(String[] args) {
		
//=========================================================================

		List<String> list1 = Arrays.asList("A", "B");
		List<String> list2 = Arrays.asList("C", "D", "E");
		List<String> list3 = Arrays.asList("F", "G");
		
		List<List<String>> allList = Arrays.asList(list1, list2, list3);
		System.out.println(allList);					// [[A, B], [C, D, E], [F, G]]
		
		
		List<String> collectedSingleLista = allList.stream().flatMap(item -> item.stream()).collect(Collectors.toList());	// flatMap "List" lega aur uska "Stream" return karega 
		System.out.println(collectedSingleLista);		// [A, B, C, D, E, F, G]
		
		
		List<String> collectedSingleListb = Stream.of(list1, list2, list3).flatMap(item -> item.stream()).collect(Collectors.toList());	// flatMap "List" lega aur uska "Stream" return karega 
		System.out.println(collectedSingleListb);
		
		
		List<String> collectedSingleListc = Stream.of(list1, list2, list3).flatMap(List::stream).collect(Collectors.toList());
		System.out.println(collectedSingleListc);
		
		
		
//=========================================================================		

		List<Integer> intList1 = Arrays.asList(3, 5, 7, 11, 13);
		List<Integer> intList2 = Arrays.asList(1, 3, 5, 7);
		List<Integer> intList3 = Arrays.asList(2, 4, 6, 8, 10);

		List<Integer> collectedIntList = Stream.of(intList1, intList2, intList3).flatMap(item -> item.stream()).collect(Collectors.toList());	
		collectedIntList.stream().filter(n -> n != 3).forEach(i -> System.out.print(i +" "));
		
		System.out.println();
		
		// In single line -
		Stream.of(intList1, intList2, intList3).flatMap(item -> item.stream()).filter(n -> n != 3).forEach(i -> System.out.print(i +" "));
//		Stream.of(intList1, intList2, intList3).flatMap(List::stream).filter(n -> n != 3).forEach(System.out::println);
		
		
	}
}


