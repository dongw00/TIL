package dp;

import java.util.Scanner;

public class Beak11727 {
	static int[] memo;

	private static int dp(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (memo[n] > 0)
			return memo[n];
		memo[n] = 2 * dp(n - 2) + dp(n - 1);
		memo[n] %= 10007;
		return memo[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		memo = new int[n + 1];

		System.out.println(dp(n));

		sc.close();
	}
}
