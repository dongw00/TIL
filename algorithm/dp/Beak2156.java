package dp;

import java.util.Scanner;

public class Beak2156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[][] d = new int[n + 1][3];
		
		for (int i = 1; i <=n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
			d[i][1] = d[i - 1][0] + arr[i];
			d[i][2] = d[i - 1][1] + arr[i];
		}

		int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
		System.out.println(ans);

		sc.close();
	}
}
