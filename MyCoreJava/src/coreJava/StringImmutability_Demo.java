package coreJava;

public class StringImmutability_Demo {

	public static void main(String[] args) {

		StringBuffer sb1 = new StringBuffer("rahul");
		
		StringBuffer sb2 = sb1;
		
		sb2.append("sinha");			// Since sb1 and sb2 both are pointing to same obj, therefore on anyone change will affect both values.  
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println("sb1==sb2 : "+(sb1==sb2));
		
	//----------------------------------------------------------------------------
	System.out.println("----------------------------------------------------------");
		
		String s1 = new String("rahul");
		
		String s2 = s1;
		System.out.println("s1==s2 : "+(s1==s2));
		
		s2 = s2.concat("sinha");			// At this line, a new object "rahulsinha" will get create in StringConstatPool, and now s2 will start pointing to this new obj, and s2 will now stop pointing to original "rahul" obj.   
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("s1==s2 : "+(s1==s2));
		
		
	}
}
