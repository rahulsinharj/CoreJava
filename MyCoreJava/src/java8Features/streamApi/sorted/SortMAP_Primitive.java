package java8Features.streamApi.sorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortMAP_Primitive {

	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("four", 4);
		map.put("ten", 10);
		map.put("nine", 9);
		map.put("six", 6);
		map.put("eight", 8);
		
		
//===[ Collections.sort(List<T>) always accepts a List ; therefore we have to extract list values from HashMap] =>  Convert MAP into "EntrySet" ]=== 
		
		ArrayList<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());	// map.entrySet() returns a set view of all the mappings (entries) present in the hashmap.     
		
/*		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() 
		{
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
		});	
*/

/*		Collections.sort(entryList, (e1, e2) -> {
			return e1.getKey().compareTo(e2.getKey());
		});
*/

/*		Collections.sort(entryList, (e1, e2) -> e1.getKey().compareTo(e2.getKey()) );
		
		for (Entry<String, Integer> e : entryList) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
*/	
		
		
		
//============[Using STREAMAPI ::]===============		
	
		// Comparing by KEY ::
		map.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).forEach(System.out::println);
		System.out.println("------------------------------------");	
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("------------------------------------");
		
		
		// Comparing by VALUE ::		
		map.entrySet().stream().sorted((e1 ,e2) -> e1.getValue() - e2.getValue()).forEach(System.out::println);
		System.out.println("------------------------------------");	
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("------------------------------------");
		
		
	}
}






//=====XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx=================

/*========// Not recommended - (map.keySet()) ::
 
	 	ArrayList<String> eList = new ArrayList<>(map.keySet());		// map.keySet() not recommended for during sorting , only used to traverse  
		Collections.sort(eList, (e1, e2) -> e1.compareTo(e2) );
			
		for (String e : eList) {
			System.out.println(e + " " + map.get(e));
		}
		
*/