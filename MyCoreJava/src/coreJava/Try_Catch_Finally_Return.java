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
			return 50;										// 
		}
	
	}
}