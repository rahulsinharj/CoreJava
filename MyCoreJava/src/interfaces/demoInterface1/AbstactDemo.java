package interfaces.demoInterface1;

abstract class MyAbstract
{
	public abstract void m1();
	
//	public static void m2();				// Methods with having only method-declarations (having no method-definition) are required to be made as "abstract".
//	public abstract static void m2();		
/*
	We can't simply declare static methods (without any method-definition), Neither we can combine static with abstract keyword.
			Because Static thing works with Compile time Polymorphism.
			Whereas Abstract thing works with Runtime Polymorphism.
	"abstract" ==> says it’s a must to override this method.
	"static" ==> says there is no relevance use of overriding the static method, because in that case it will be Method Hiding. 
				 	And if we call that overridden static method in child class using Parent reference it will only call parent static method only.
*/
	
	public static void m2(){			
		
		System.out.println("Inside MyAbstract-AbstractClass-M2 method");
	}
	
}

public class AbstactDemo extends MyAbstract {

	@Override
	public void m1() {
		System.out.println("Inside AbstactDemo-NormalClass-M1 method");
	}
	
	public static void main(String[] args) {
		
		AbstactDemo obj = new AbstactDemo();
		obj.m1();
		MyAbstract.m2();

	}
}
