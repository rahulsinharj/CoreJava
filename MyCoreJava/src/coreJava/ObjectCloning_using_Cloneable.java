package coreJava;

class Boy implements Cloneable {
	int pen;
	int pencil;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Boy [pen= " + pen + ", pencil= " + pencil + "]";
	}
	
}

public class ObjectCloning_using_Cloneable {

	public static void main(String[] args) {

		Boy obj1 = new Boy();
		obj1.pen = 5;
		obj1.pencil = 8;
		
		System.out.println(obj1);
		
		Boy obj2 = null;
		try 
		{
			obj2 = (Boy)obj1.clone();
		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(obj2); 		// 5  8

	}

}
