package interfaceDemo2;

interface InterfABCD
{
	void show(int i);
	
}

public class InterifLambdaAnonymous {

	public static void main(String[] args) 
	{
//		InterfABCD obj = (i)->
//				  	{
//						System.out.println("inside Anonymous show");
//					};
		
		InterfABCD obj = i -> System.out.println("inside Lambda AnonymousImpl show : "+i); 		// For single line method body
		
		obj.show(7);

	}


}
 