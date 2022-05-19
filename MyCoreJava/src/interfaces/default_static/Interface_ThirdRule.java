package interfaces.default_static;

interface Inf
{	
	default void show()
	{
		System.out.println("Inside Interface Inf");
	}
}

class A
{
	public void show()
	{
		System.out.println("Inside Class A");
	}
}

/*	If any class has extended a class-A {having method show()} and also implemented Interface-Inf {having method default show()} ; 
  		then Class-A show() method will be given more priority / not the default show() method of Interface.
  
 * 	Since class has more power compare to interface ; therefore inherited show() method of Class-A will hide the inherited show() method from Interface-Inf      
 *  Default method will have low priority ; and normal method will have high priority.
*/
public class Interface_ThirdRule extends A implements Inf
{
	public static void main(String[] args) 
	{
		Interface_ThirdRule obj = new Interface_ThirdRule();
		obj.show();
		

	}

}
