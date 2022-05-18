package java8Features;

@FunctionalInterface
interface Operation
{
	public int someOperation(int x, int y);
}

public class FunctionalInterface_MethodReference {

	public static void result(int x, int y, Operation op)
	{
		System.out.println(op.someOperation(x, y));
	}
	
	public static void main(String[] args) {
		
		result(8, 5, new Operation() 					
		{
			@Override									// Using Anonymous class implementation
			public int someOperation(int a, int b) {
				return a+b;
			}
		});
		
		result(8, 5, (a,b)->(a*b));			// Using Lambda implementation of Functional interface

		result(8, 5, (a,b)->(a-b));

		result(8, 5, (a,b)->(a+b));			// ye operation "(a,b)->(a+b)" jo 2 argument ke raha hai aur return kar raha hai unka addition (a+b) ; iske saath agar koi aur bhi bahot sa bada calculation karna hua to ye ham ek alag se method me bhi rakh ke kar sakte hai.   
														// see below -	
		result(8, 5, MyTask::add);			// providing interface implementation using METHOD REFERENCE
	
	}
	
}

class MyTask
{
	public static int add(int a, int b)
	{
		return a+b;
	}
}
