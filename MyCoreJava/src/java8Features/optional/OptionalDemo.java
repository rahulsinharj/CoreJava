package java8Features.optional;

import java.util.Optional;		

//	Optional class provides a solution for "representing optional values" instead of null references.
public class OptionalDemo {

	public static void main(String[] args) {		// It tries to avoid NullPointerExceptions
		
//		String str = null;
		String str = "Java Programming";
		
		if(str == null) {
			System.out.println("This is null object");
		}
		else {
			System.out.println(str.length());
		}
	

//		Optional<String> opStr = Optional.of(str);					// Doesn't handles null calls //Returns an Optional with the specified present non-null value. 
		Optional<String> opStr = Optional.ofNullable(str);			// Also handles null calls	  //Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.

		System.out.println(opStr.isPresent());

		System.out.println(opStr.get());
		
		System.out.println(opStr.orElse("null String"));
		
		
		
	}
}
