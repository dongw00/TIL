package dp;

import java.util.*;

public class FibonacciExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int memo[] = new int[n + 1];

		System.out.println(fibonacci(n, memo));
	}

	private static int fibonacci(int n, int[] memo) {
		if (n <= 1)
			return n;
		else if (n == 2)
			return 1;
		else {
			if (memo[n] > 0)
				return memo[n];
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);

			return memo[n];
		}
	}
}
