package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2749 {
	static final int mod = 1000000;
	static final int p = mod / 10 * 15;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		n %= p;

		long[] memo = new long[p + 1];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i <= p; i++)
			memo[i] = (memo[i - 1] + memo[i - 2]) % mod;

		System.out.println(memo[(int) n]);

	}
}
