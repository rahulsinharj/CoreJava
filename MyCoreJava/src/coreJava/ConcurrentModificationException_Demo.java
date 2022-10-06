package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException_Demo {

	public static void main(String[] args) {

		ArrayList<String> chList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

		for (int i = 0; i < chList.size(); i++) {
			String ch = chList.get(i);
			if (ch.equals("a"))
				chList.remove(ch);

//			System.out.println(chList.size());
		}

		// Below code will occur ConcurrentModificationException 
		
//		for (String ch : chList) {
//			if (ch.equals("a"))
//				chList.remove(ch);
//		}

		System.out.println(chList);
		System.out.println("=============================================");
	
//-------------------------------------------------------------------------------------------------------------------
		
		List<String> sList = new ArrayList<>(Arrays.asList("vikas", "shivam", "rahul", "gaurav"));

		System.out.println(sList);

		Iterator<String> itr = sList.iterator();
		while(itr.hasNext())
		{
			String s = itr.next();
			
			System.out.println(s);
			if(s.equals("vikas"))
			{
//				sList.remove(s);				// Not to use List's remove() method 
				itr.remove();					// We should use Iterator remove() method to remove this "ConcurrentModificationException"			
			}
		}

		System.out.println(sList);
		
	}
}

/*	This java.util.ConcurrentModificationException occur when we remove elements while iterating ArrayList in java. 
  
 *	Even though ArrayList provides remove() method, we cannot use that to remove item while iterating over ArrayList in java, because they will throw concurrent modification exception.
 *	The right way to remove elements from ArrayList while iterating over it is – by using Iterator remove() method, instead of ArrayList remove() method.
 
 *	While using Iterator -> ConcurrentModificationException doesn't occur, because it also removes the current element and also updates the counter and variables used by Iterator like modeCount, which indicate that the modification is done by the Iterator itself, not somewhere around.
  
*/


