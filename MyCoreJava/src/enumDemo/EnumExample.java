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

	enum Student							// Creating ENUM inside the class
	{
		Ram, Shyam, Geeta, Pawan, Priya
	}
	
	enum Book 								// Creating ENUM having some values - to be provided as parameter through private constructor
	{
		MyJava("java8"), MyPython("python3"), MySpringBoot("springboot4");
		String value;
		
		private Book(String value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args) 
	{
		System.out.println(Student.Pawan);
		System.out.println(Student.Shyam);
		System.out.println(Student.Geeta);
		System.out.println(Student.Pawan);
		System.out.println(Student.Priya);
		
		Student[] studs = Student.values();
		System.out.println(Arrays.toString(studs));
		
		System.out.println("===========================================");
		
		System.out.println(Book.MyJava);
		System.out.println(Book.MyJava.value);
		
		System.out.println(Book.MyPython.value);
		System.out.println(Book.MySpringBoot.value);
		
		
		System.out.println("===========================================");
		
		System.out.println(Mobile.APPLE +"	--  "+Mobile.APPLE.ordinal() +"	-- "+Mobile.APPLE.getPrice());						// Mobile.APPLE.ordinal() => ordinal() means the order of ENUM object (here APPLE)  
		System.out.println(Mobile.SAMSUNG +"	--  "+Mobile.SAMSUNG.ordinal()+"	-- "+Mobile.SAMSUNG.getPrice());
		System.out.println(Mobile.POCO +"	--  "+Mobile.POCO.ordinal()+"	-- "+Mobile.POCO.getPrice());

		Mobile[] mobs = Mobile.values();						// This values() method is not inside ENUM class, but it is automatically given by Java compiler/JVM. Not even in Object class.    
		System.out.println(Arrays.toString(mobs));


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
