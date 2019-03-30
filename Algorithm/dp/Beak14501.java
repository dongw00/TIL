package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14501 {
	static int MAX = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n + 2];
		int[] p = new int[n + 2];
		int[] d = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n; i > 0; i--) {
			int day = i + t[i];

			if (day <= n + 1)
				d[i] = Math.max(p[i] + d[day], d[i + 1]);
			else
				d[i] = d[i + 1];
		}

		System.out.println(d[1]);
	}
}
