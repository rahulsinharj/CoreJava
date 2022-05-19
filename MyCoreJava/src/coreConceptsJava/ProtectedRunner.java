package coreConceptsJava;

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
	public void m1() {			// This override is not at all required , but to access m1() method of ProtectedA -> it is a must to extend "ProtectedA" class inside "ProtectedRunner" 
		super.m1();
	}
	
	
}
