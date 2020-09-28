package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak15988 {
	static long[] memo = new long[1000001];

	private static long dp(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (memo[n] > 0)
			return memo[n];
		if (n < 3)
			memo[n] = dp(n - 1) + dp(n - 2);
		else
			memo[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
		memo[n] %= 1000000009L;
		return memo[n];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp(n));
		}
	}
}
