package divideConquer;

import java.util.*;
import java.io.*;

public class Beak1629 {
	static int mod;

	public static long calcPow(long a, long b) {
		if (b == 1)
			return a;
		else {
			long tmp = calcPow(a, b / 2);

			if (b % 2 == 0)
				return (tmp * tmp) % mod;
			else
				return ((tmp * tmp) % mod * a) % mod;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());

		System.out.println(calcPow(a % mod, b));
	}
}
