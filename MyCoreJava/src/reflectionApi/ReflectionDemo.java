package reflectionApi;

interface A {	}

class C	{	}

class B 			// extends C
{
	
}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception 
	{
		Class clsA = Class.forName("reflectionApi.A");
		System.out.println(clsA.isInterface());

		Class clsB = Class.forName("reflectionApi.B");
		System.out.println(clsB.isInterface());
		System.out.println(clsB.getSuperclass());
		
		
		
	}

}
