package dp;

import java.io.*;

public class Beak1904 {
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		System.out.println(dp(n) % 15746);
	}

	private static int dp(int n) {
		if (n <= 1)
			return 1;
		else {
			if (arr[n] > 0)
				return arr[n];
			arr[n] = dp(n - 1) % 15746 + dp(n - 2) % 15746;
			return arr[n] % 15746;
		}
	}

}
