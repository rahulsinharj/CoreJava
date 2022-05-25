package designPattern.singleton;

public class SingletonPattern_Enum {

	public static void main(String[] args) {

		Singleton obj1 = Singleton.INSTANCE;
		System.out.println("obj1 "+obj1 +" | Hashcode= "+obj1.hashCode());
		
		Singleton obj2 = Singleton.INSTANCE;
		System.out.println("obj2 "+obj2 +" | Hashcode= "+obj2.hashCode());

		
	}
}

enum Singleton				// Special type of class
{
	INSTANCE;				// by default it has inbuilt definition of a method => public static getInstance() { }
													// Also it has bydefault a private constructor.	
	public void show()
	{
		System.out.println("inside Singleton");
	}
}

/*	Deserialization (which takes data structured from some format, and rebuilding it into an object)
 
   	Whenever we work with Deserialization, we use a method readObjet() to get the object. So even if our class in Singleton through Synchronized, 
   		readObjet() will surely give us only a NEW object of that Singleton class.
   		
   	That's why using ENUM, there is a method readResolve() 	=>  It will not create a new Object, it will use the current object itself.
   	- That's the advantage of using ENUM for creating SINGLETON design pattern.
   	
*/