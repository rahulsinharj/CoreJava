package java8Features.streamApi.map;

import java.util.Arrays;
import java.util.List;

public class TransformStringToUpperCase {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Ross", "Chandler", "CSS", "Monica", "Joey", "Rachel");

		list.stream().map(name -> name.toUpperCase())
					 .forEach(name -> System.out.print(name + " "));

	}

}
