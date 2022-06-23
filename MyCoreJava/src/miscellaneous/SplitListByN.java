package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class SplitListByN {

	public static void main(String[] args) {
		
		int arr [] = {1 , 3, 5, 7, 9};
		int splitValue = 2 ;
		
		sliptByN(arr, splitValue);

	}

	public static void sliptByN(int[] arr, int splitValue) 
	{		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>(); 
		
		int count = 0;
		for(int i=0 ; i <arr.length; i++ )
		{
			count++;
			subList.add(arr[i]);
			
			if(count == splitValue )
			{
				list.add(subList);
				subList = new ArrayList<Integer>();		// Creating an empty SubList
				count = 0;
			}
			
		}
		if(subList.size() != 0)
			list.add(subList);
		
		System.out.println(list);
	}

}
