package demo;

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

			System.out.println(chList.size());
		}

//		for (String ch : chList) {
//			if (ch.equals("a"))
//				list.remove(ch);
//		}

		System.out.println(chList);

		System.out.println("=============================================");
		
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
