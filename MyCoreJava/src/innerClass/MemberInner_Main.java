package innerClass;
	
class A
{
	int rollno;
	String name;
	
	class B
	{
		public void show() {
			System.out.println("Hello B inside A");
		}
	}
	
}

public class MemberInnerClass {

	public static void main(String[] args) {
	
		A objA = new A();
		
		A.B objB = objA.new B();
		objB.show();
		
	}

}
