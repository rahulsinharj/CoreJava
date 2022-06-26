package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap {

	public static void main(String[] args) 
	{
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);
		hm.put("d", 5);

		System.out.println(hm.get("a")); 					// 1
		System.out.println(hm.containsKey("b")); 			// true

		System.out.println(hm);
		
		hm.forEach((key, value) -> System.out.println(key + "  :  " + value));

		System.out.println("=======================================");
		
		Set<String> keys = hm.keySet();
		System.out.println(keys); 							// [a, b, c, d]
		
		System.out.println("=======================================");
		for (String key : hm.keySet()) 
		{
			int val = hm.get(key); 							// "int" is allowed here, no need of "Integer"
			System.out.println(key + "  :  " + val); 			// prints key...values per pair - per line
		}

		System.out.println("=======================================");		
		for(Map.Entry<String, Integer> map : hm.entrySet())
		{
			System.out.println(map.getKey() +"  :  "+map.getValue());
		}
		
		System.out.println("=======================================");
		
		
		
		
		
	}
}
