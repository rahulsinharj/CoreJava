package innerClass;

class M
{
	public void show() {
		System.out.println("Inside class M");
	}
}

/*
class N extends M
{
	public void show() {
		System.out.println("Class N is implementation of Class M");
	}
}
*/

public class AnonymousInnerClass {

	public static void main(String[] args) {
	
//		M objM = new N();
//		objM.show();
		
		M objM = new M() 
		{
			public void show() 
			{
				System.out.println("M implementation using Annonymous Inner class");
			}
		};
		
		objM.show();
		
	}

}
