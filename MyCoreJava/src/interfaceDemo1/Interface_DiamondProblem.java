package interfaceDemo1;

interface Inf1
{
	default void show() 
	{
		System.out.println("Inside Interface Inf1");
	}
}
interface Inf2
{
	default void show() 
	{
		System.out.println("Inside Interface Inf2");
	}
}

public class Interface_DiamondProblem implements Inf1, Inf2
{
	@Override
	public void show() 			// If we we interface Inf1,Inf2 and both have same method show() with defined body -> then if any class implements both the interfaces, then its compulsory to override that show() method in the implementation class.    
	{										// Otherwise it will create confusion for JVM that which show() method to call ; is it Inf1-show() or Inf2-show()  
//		Inf1.super.show();
		Inf2.super.show();
		
		System.out.println("Inside Interface Implementation");
	}

	public static void main(String[] args) 
	{
		Interface_DiamondProblem iObj = new Interface_DiamondProblem();
		iObj.show();
	
		
		
	}
	
}
