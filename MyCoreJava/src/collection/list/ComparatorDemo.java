package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<Integer>();
		list.add(305);
		list.add(998);
		list.add(774);
		list.add(236);
		list.add(881);
		
		Comparator<Integer> comp = new Comparator<Integer>() 
		{
			@Override
			public int compare(Integer i1, Integer i2) 
			{
				if(i1%10 > i2%10)			// Sorting based on the unit places - that unit digit we can get by modulo_10
					return 1;
				else
					return -1;
			}
		};
		
		Collections.sort(list, comp);
//		Collections.sort(list, (i1,i2) -> i1%10 > i2%10 ? 1 : -1);			// same logic using lambda expression
		
		list.forEach(System.out::println);
		
		
	}
}
