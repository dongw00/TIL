package dp;

import java.io.*;

public class Beak9461 {
	static long[] d = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		d[0] = d[1] = d[2] = d[3] = 1;
		d[4] = d[5] = 2;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(dp(n));
		}
	}

	private static long dp(int n) {
		if (d[n] > 0)
			return d[n];
		d[n] = dp(n - 1) + dp(n - 5);
		return d[n];
	}
}
