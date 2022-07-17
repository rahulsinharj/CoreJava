package java8Features.optional;

import java.util.Optional;
import java.util.function.Supplier;		

//	Optional class provides a solution for "representing optional values" instead of null references.
public class OptionalDemo {

	public static void main(String[] args) {		// It tries to avoid NullPointerExceptions
		
		String str = null;
//		String str = "Java Programming";
		
		if(str == null) {
			System.out.println("This is null object");
		}
		else {
			System.out.println(str.length());
		}
	

//		Optional<String> opStr = Optional.of(str);					// Doesn't handles null calls //Returns an Optional with the specified present non-null value. 
		Optional<String> opStr = Optional.ofNullable(str);			// Also handles null calls	  //Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.

		System.out.println("If Present : "+opStr.isPresent());

//		System.out.println(opStr.get());						 	// If opStr value comes null, then on calling null.get(), it will return NullPointerException
		
		System.out.println(opStr.orElse("null String"));			// But here, If opStr value comes null, then on calling null.get(), it will return else part (whatever we have inserted).

		System.out.println(opStr.orElseGet(() -> "null Value"));			// Supplier Interface (Functional Interface)

		System.out.println(opStr.map(String::toUpperCase).orElseGet(() -> "It's a null Value"));			// Supplier Interface (Functional Interface)
		
		
		
		
		
	}
}
