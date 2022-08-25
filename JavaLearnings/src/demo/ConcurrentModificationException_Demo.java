package demo;

import java.util.ArrayList;

public class ConcurrentModificationException_Demo {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();

		list.add("b");
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("e");

//	for(int i=0; i< list.size(); i++)
//	{
//		String ch = list.get(i);
//		if(ch.equals("a"))
//			list.remove(ch);
//		
//		System.out.println(list.size());
//	}

		for (String ch : list) {
			if (ch.equals("a"))
				list.remove(ch);
		}

		System.out.println(list);

	}
}
