package java8Features.streamApi.map;

import java.util.ArrayList;
import java.util.List;

public class StreamApi_mapToInt {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();	// [8, 3, 12, 4]
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(9);
		list.add(15);
		list.add(7);
		
		int intMin = list.stream().mapToInt(i->i).min().getAsInt();
		System.out.println("intMin : "+intMin);
		
		int intMax = list.stream().mapToInt(i->i).max().getAsInt();
		System.out.println("intMax : "+intMax);
		
		int intSum = list.stream().mapToInt(i->i).sum();
		System.out.println("intSum : "+intSum);
		
		double avrg = list.stream().mapToInt(i->i).average().getAsDouble();
		System.out.println("Average : "+avrg);
		
		
		
		
		
		
	}

}
