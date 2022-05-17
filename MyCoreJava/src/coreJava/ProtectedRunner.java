package coreJava;

class ProtectedA {

	protected void m1() 
	{
		System.out.println("Inside ProtectedA m1-method");
	}
}

public class ProtectedRunner extends ProtectedA {

	public static void main(String[] args) {

		ProtectedRunner obj = new ProtectedRunner();
		obj.m1();

	}

	@Override
	public void m1() {			// This override is not at all required , but to extend "ProtectedA" inside "ProtectedRunner" is a must here to access m1() of ProtectedA   
		super.m1();
	}
	
	
}
