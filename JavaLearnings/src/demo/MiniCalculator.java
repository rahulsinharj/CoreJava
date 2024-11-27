package demo;

import java.util.Scanner;

public class MiniCalculator {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int a = kb.nextInt();
		char op = kb.next().charAt(0);
		int b = kb.nextInt();

		System.out.println(cal(a, b, op));

	}

	public static int cal(int a, int b, char op) {
	
		switch (op) {
		case '+':
			return a + b;

		case '-':
			return a - b;

		case '*':
			return a * b;

		case '/':
			return a / b;

		case '%':
			return a % b;

		}
		return 0;

	}

}
