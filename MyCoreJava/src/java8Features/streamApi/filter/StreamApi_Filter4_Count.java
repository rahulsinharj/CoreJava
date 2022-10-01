package java8Features.streamApi.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi_Filter4_Count {					// Using StreamAPI + filter() + count() 

	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("rahul");
		list.add("rohit");
		list.add("shubham");
		list.add("ramesh");
		list.add("shivam");
		list.add("rishav");
		
		
		long count = list.stream().filter(s -> s.startsWith("r")).count();
		System.out.println(count);
		

		List<String> collect = list.stream().filter(s -> s.startsWith("r")).collect(Collectors.toList());
		System.out.println(collect);
		
		list.stream().filter(s -> s.startsWith("r")).forEach(System.out::println);


	}

}
