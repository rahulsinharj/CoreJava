package collection.list_Comparable_Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSorting {

	public static void main(String[] args) {

		int[] val = { 60, 120, 100, };
		int[] weight = { 10, 30, 20 };

		int n = val.length;
		int[][] items = new int[n][2];

		// Fill A and weight into items array
		for (int i = 0; i < n; i++) {
			items[i][0] = val[i]; // value
			items[i][1] = weight[i]; // weight
		}

		arrays_sort__Lambda_based(Arrays.copyOf(items, n));
		arrays_sort__without_lambda(Arrays.copyOf(items, n));
		arrays_sort__with_Comparator_Class(Arrays.copyOf(items, n));
		arrays_sort__with_Comparable_Class(Arrays.copyOf(items, n));
	}

// ===============================================================================================================

	public static void arrays_sort__Lambda_based(int[][] items) {

		// Sort by value-to-weight ratio in descending order using lambda
		Arrays.sort(items, (item1, item2) -> {
			double ratio1 = (1.0 * item1[0]) / item1[1];
			double ratio2 = (1.0 * item2[0]) / item2[1];
			return Double.compare(ratio2, ratio1); // For descending order
		});

		// Print the result
		Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);
	}

// ===============================================================================================================

	public static void arrays_sort__without_lambda(int[][] items) {

		// Sort by value-to-weight ratio in descending order using lambda
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] item1, int[] item2) {
				double ratio1 = (1.0 * item1[0]) / item1[1];
				double ratio2 = (1.0 * item2[0]) / item2[1];
				return Double.compare(ratio2, ratio1); // For descending order
			}
		});

		// Print the result
		Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);
	}

// ===============================================================================================================

	public static void arrays_sort__with_Comparator_Class(int[][] items) {

		// Sort items based on value-to-weight ratio in descending order
		Arrays.sort(items, new ItemComparator());

		// Print the result
		Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);

	}

	// Comparison function to sort items based on value/weight ratio
	static class ItemComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			double a1 = (1.0 * a[0]) / a[1];
			double b1 = (1.0 * b[0]) / b[1];
			return Double.compare(b1, a1);
		}
	}

// ===============================================================================================================

	public static void arrays_sort__with_Comparable_Class(int[][] items) {

		// Sort by value-to-weight ratio descending
		Arrays.sort(items);

		// Print the result
		Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);
	}

	// Item class with value, weight, and Comparable for sorting by value/weight
	// ratio
	class Item implements Comparable<Item> {
		int value;
		int weight;

		Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		// Compare items by value-to-weight ratio (descending)
		@Override
		public int compareTo(Item other) {
			double ratio1 = 1.0 * this.value / this.weight;
			double ratio2 = 1.0 * other.value / other.weight;
			return Double.compare(ratio2, ratio1); // descending order
		}
	}
}
