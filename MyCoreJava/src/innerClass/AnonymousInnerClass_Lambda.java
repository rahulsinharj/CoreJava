package innerClass;

interface P
{
	public void show();				// Since this P interface has only one method , therefore this is a functional interface.
}									// And for functional interface we can provide annonymous class implementation using LAMBDA expression.    

/*
class Q implements P
{
	public void show() {
		System.out.println("Class Q is implementation of Interface P");
	}
}
*/

public class AnonymousInnerClass_Lambda {

	public static void main(String[] args) {
	
//		P objP = new Q();
//		objP.show();
		
		P objP = () ->
		{
			System.out.println("P implementation using Annonymous Inner class using 'LAMBDA' ");
		};
		
		objP.show();
		
	}

} 
