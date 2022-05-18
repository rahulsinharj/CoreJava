package java8Features.streamApi.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi_Filter3 {

	public static void main(String[] args) 
	{
		List<String> newList = Arrays.asList("Java", "JavaScript", "Java", "Python", "Ruby", "JSON", "Scala", "Dart")
				.stream()
				.filter(x -> x.contains("J"))
				.collect(Collectors.toList());			// Collectors.toList()

		System.out.println(newList);

//=========================================================================	

		List<String> myList = Arrays.asList("Java", "JavaScript", "Java", "Python", "Ruby", "JSON", "Scala", "Dart");
		
		Set<String> newSet = myList.stream()
						   .filter(x -> x.contains("J"))
						   .collect(Collectors.toSet());		// Collectors.toSet()
		
		System.out.println(newSet);



	}

}
