package coreJava;

public class StringImmutability_Demo {

	public static void main(String[] args) {

		StringBuffer sb1 = new StringBuffer("rahul");
		
		StringBuffer sb2 = sb1;
		
		sb2.append("sinha");			// Since sb1 and sb2 both are pointing to same obj, therefore on anyone change will affect both values.  
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println("sb1==sb2 : "+(sb1==sb2));
		
		
		final StringBuffer sb = new StringBuffer("sneha");
//		sb = sb.append("sinha");			// since "StringBuffer sb" is final, that means we cannot reassign any other value to this "sb" again.
		sb.append("sinha");					// But final doesn't mean that it is also immutable now, NO ; "StringBuffer sb" is still mutable, since we are able to change its state/value. That means making object as 'final' won't make it mutable as well.	 
		System.out.println(sb);
		
		
	//----------------------------------------------------------------------------
	System.out.println("----------------------------------------------------------");
		
		String s1 = new String("rahul");
		
		String s2 = s1;
		System.out.println("s1==s2 : "+(s1==s2));
		
		s2 = s2.concat("sinha");			// At this line, a new object "rahulsinha" will get create in StringConstatPool, and now s2 will start pointing to this new obj, and s2 will now stop pointing to original "rahul" obj.   
											//  because String is immutable (original value can't be modified/changed ; if we do so then only a new object with the updated value will be created)
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("s1==s2 : "+(s1==s2));
		
		
	}
}
