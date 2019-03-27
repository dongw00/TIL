package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak10870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] fibo = new int[n + 1];

		if (n < 2) {
			System.out.println(n);
			System.exit(0);
		}

		fibo[1] = 1;

		for (int i = 2; i <= n; i++)
			fibo[i] = fibo[i - 1] + fibo[i - 2];

		System.out.println(fibo[n]);
	}
}
