package coreConceptsJava;

public class MyExceptionCustomizable {

	public static void main(String[] args) {
		int i = 5;
		
		try 
		{
			if(i<10)
			{
				throw new MyException("Customizable error");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyException extends RuntimeException   // or, extends Exception 
{
	public MyException(String msg)
	{
		super(msg);						// This  will call the constructor of Exception Class. 
	}
}
