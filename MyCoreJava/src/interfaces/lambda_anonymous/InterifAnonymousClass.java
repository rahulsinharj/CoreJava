package interfaces.lambda_anonymous;

interface InterfABC
{
	void show(int i);
}
/*
class ABCimpl implements InterfABC
{
	@Override
	public void show() 
	{
		System.out.println("inside Show-method");
	}	
}
*/
public class InterifAnonymousClass { 

	public static void main(String[] args) 
	{
//		InterfABC obj = new ABC();				// Creating instance of Interface is not possible.

//		InterfABC obj = new ABCimpl();			// This is fine if we have an implemented class ABCimpl
		
		InterfABC obj = new InterfABC() {
			
			@Override
			public void show(int i)					// Anonymous class - without any name, having only the implementation 
			{
				System.out.println("inside AnonymousClass show method : "+i);
			}
		};
		
		obj.show(5);
		
		
		
	}

}
