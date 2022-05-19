package interfaces.default_static;

interface Interf {
	default void m1() {
		System.out.println("Interface M1");
	}

	public static void m2() {					// Interface STATIC method is bydefault not available to the implementation classes. 
		System.out.println("Interface M2");
	}
}

public class InterfUsing_Default_Static implements Interf {
	
//	public void m1() {
//		System.out.println("InterfMainCLASS M1");
//	}

	public static void m2() {					// If we comment this overridden method here, then Line 30,31 will not Compile. 
		System.out.println("InterfMainCLASS M2");
	}

	public static void main(String[] args) 
	{
		InterfUsing_Default_Static obj = new InterfUsing_Default_Static();
		obj.m1();

		System.out.println();	
		
		Interf.m2();								// NonAbstract Static method of Interface can only be called through Interface name .dot static method() name  
		InterfUsing_Default_Static.m2();
		m2();
		
	}
} 
