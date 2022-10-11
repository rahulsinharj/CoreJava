package java8Features.streamApi.maxMin;

import java.util.Arrays;

public class StreamApi_MaxMin {

	public static void main(String[] args) {

		int[] arr = { 4, 8, 9, 2, 7, 5 };

		int min = Arrays.stream(arr).min().getAsInt();
		System.out.println(min);

		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println(max);

	}

}
