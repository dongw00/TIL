package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Beak10826 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger[] fibo = new BigInteger[n + 3];

		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;

		for (int i = 2; i <= n; i++)
			fibo[i] = fibo[i - 1].add(fibo[i - 2]);

		System.out.println(fibo[n]);
	}
}
