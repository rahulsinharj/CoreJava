package innerClass;

class C
{
	int rollno;
	String name;
	
	static class D
	{
		public void show() {
			System.out.println("Hello C inside D");
		}
	}
	
}

public class NestedInnerClass {						// using static (i.e, static inner class)

	public static void main(String[] args) {
		
		C.D objD = new C.D();
		objD.show();

	}

}
