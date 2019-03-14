package dp;

import java.util.Scanner;

public class Beak15990 {
	static final long mod = 1000000009L;
	private static long[][] d = new long[100001][4];

	private static long dp(int n, int m) {
		if (n == 1 || n == 2 && m == 2 || n == 3 && m == 3) {
			return 1;
		}
		if (d[n][m] > 0)
			return d[n][m];
		for (int i = 1; i <= 3; i++) {
			if (i == 1 && n >= 1)
				d[n][i] = dp(n - 1, 2) + dp(n - 2, 3);
			else if (i == 2 && n >= 2)
				d[n][i] = dp(n - 1, 1) + dp(n - 2, 3);
			else if (i == 3 && n >= 3) {
				d[n][i] = dp(n - 1, 1) + dp(n - 2, 2);
			}
		}
		return d[n][m] % mod;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int num = sc.nextInt();
			System.out.println(dp(num, 1));
		}

		sc.close();
	}
}
