package coreJava;

public class Try_Catch_Finally_Return {

	public static void main(String[] args) {

		System.out.println(m1());

	}

	private static int m1() {
		try {
			System.out.println("I am in try block");
//			return 10 / 5;
			return 10 / 0;									// Due to this line, ArithmeticException is occurring ; if we correct this line by changing it to "return 10 / 5"; then our code won't go to Catch block.  
		} 
		catch (ArithmeticException e) {
			System.out.println("I am in catch block "+e);
			return 40;
		} 
		finally {
			System.out.println("I am in finally block");
			return 50;										// Finally overrides try return value
		}
	
	}
}
/*

 *	If the return in the try block is reached, it transfers control to the finally block, and the function eventually returns normally (not a throw).
	
 *	If an exception occurs, but then the code reaches a return from the catch block, control is transferred to the finally block and the function eventually returns normally (not a throw).
	
 *	Also even if you didn't have the catch and if an exception were thrown in the try block and not caught. By doing a return from the finally block, you suppress the exception entirely.


		https://stackoverflow.com/questions/15225819/try-catch-finally-return-clarification/
*/






