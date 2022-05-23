package java8Features.streamApi.sum;

import java.util.stream.IntStream;

public class StreaApi_sum {

	public static void main(String[] args) {

		IntStream.range(1,100).forEach(System.out::println);
		   
		int intA = IntStream.range(1, 100).reduce((a,b) -> (a+b)).getAsInt();
		int intB = IntStream.range(1, 100).reduce(Integer::sum).getAsInt();
		int intC = IntStream.range(1, 100).sum();
		
		int intD = IntStream.range(1, 100).max().getAsInt();
		
		double doubleE = IntStream.range(1, 100).average().getAsDouble();
		
		
		System.out.println("SUM ==== intA : "+intA+" | intB : "+intB+" | intC : "+intC);
		System.out.println("MAX ==== intD : "+intD);
		System.out.println("AVERAGE ==== doubleE : "+doubleE);
		
		
		
	}

}
