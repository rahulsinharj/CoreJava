package java8Features;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod_Main {

	public static void main(String[] args) 
	{
		List<Integer> values = Arrays.asList(1, 2, 3, 4);
		
//======EXTERNAL ITERATIONS :: 	Some for-loop outside your object, it will try to fetch the data (through outside) from Object.
		
//		for(int i=0 ; i<6 ; i++)
//		{
//			System.out.print(values.get(i));
//		}
//		System.out.println();

//=========================================		
		
//		Iterator<Integer> itr = values.iterator();
//		while(itr.hasNext())
//		{
//			System.out.print(itr.next());
//		}
//		System.out.println();
		
//=========================================		

//		for(int a : values)
//		{
//			System.out.print(a);
//		}
//		System.out.println();

		
//=============================================================================================================		
//======INTERNAL ITERATIONS :: 
		
		// Internal working of forEach() method , which take Consumer object ::
		Consumer<Integer> consumer = new Consumer<Integer>() 			// Creating obj of Consumer of interface, using Anonymous class 
		{
			@Override
			public void accept(Integer i) 
			{
					System.out.print(i);
			}
		}; 
		values.forEach(consumer);
			lineChange();
		
//=================================================			
		Consumer<Integer> consu = (Integer i) -> {
			System.out.print(i);
		};
		values.forEach(consu);						// Since we are using this consumer obj only once, so no need of this reference, better to directly use it's object impl as Anonymous OBJECT. 
			lineChange();
		
//=================================================			
		values.forEach(i -> System.out.print(i));		// If we have an interface with only one method, then instead of creating the object , we can directly use a lambda expression here.  
			lineChange();
		
//=================================================			
		values.forEach(System.out::print);				// Passing a print() method as reference - METHOD REFERENCE
			lineChange();
		
//=================================================			
		values.forEach(i -> doubleEach(i));
			lineChange();
		
//=================================================			
		values.forEach(ForEachMethod_Main::doubleEach);			// Passing a method as reference - METHOD REFERENCE
		
	}
	
	public static void doubleEach(int i)
	{
		System.out.print(i*2);
	}
	
	public static void lineChange() {
		System.out.println();
	}

}
