package dp;

import java.io.*;

public class Beak2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		int d[][] = new int[n + 1][2];

		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		d[1][0] = d[1][1] = arr[1];

		for (int i = 2; i <= n; i++) {
			d[i][0] = d[i - 1][1] + arr[i];
			d[i][1] = Math.max(d[i - 2][0], d[i - 2][1]) + arr[i];
		}

		System.out.println(Math.max(d[n][0], d[n][1]));
	}
}
