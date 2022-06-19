package enumDemo;

import java.util.Arrays;

/* Enumerations serve the purpose of representing a group of named constants in a programming language.  
   Every ENUM in java gets converted into a class with "static constants" as => static final Mobile APPLE = new Mobile();
  
*/

enum Mobile 					// Creating ENUM outside the class   // We cannot extends any other class into this MOBILE enum, because this MOBILE enum has already been automatically entended by ENUM CLASS.    
{																	// But we only can implement any INTERFACE into this ENUM Mobile			
	APPLE(20), SAMSUNG, POCO;

	int price;

	Mobile() 
	{
		price = 80; 		// This price=80 value will be assigned to each & every Mobile objects (APPLE, SAMSUNG, POCO )
		System.out.println("No-args Contructor is called !");
	}

	Mobile(int p) 
	{
		price = p ;
	}
	
	public int getPrice() {
		return price;
	}
}

public class EnumExample {

	enum Book // Creating ENUM inside the class
	{
		MyJava, MyPython, MySpringBoot;
	}

	public static void main(String[] args) {

		System.out.println(Mobile.APPLE +"	--  "+Mobile.APPLE.ordinal() +"	-- "+Mobile.APPLE.getPrice());						// Mobile.APPLE.ordinal() => ordinal() means the order of ENUM object (here APPLE)  
		System.out.println(Mobile.SAMSUNG +"	--  "+Mobile.SAMSUNG.ordinal()+"	-- "+Mobile.SAMSUNG.getPrice());
		System.out.println(Mobile.POCO +"	--  "+Mobile.POCO.ordinal()+"	-- "+Mobile.POCO.getPrice());

		Mobile[] mobs = Mobile.values();						// This values() method is not inside ENUM class, but it is automatically given by Java compiler/JVM. Not even in Object class.    
		System.out.println(Arrays.toString(mobs));

		
		System.out.println(Book.MyJava);
		System.out.println(Book.MyPython);
		System.out.println(Book.MySpringBoot);

		Mobile m = Mobile.SAMSUNG;

		switch (m) {
		case APPLE:
			System.out.println("Apple is best");
			break;

		case SAMSUNG:
			System.out.println("Samsung is best");
			break;

		case POCO:
			System.out.println("POCO is best");
			break;
		}

		
	}

}
