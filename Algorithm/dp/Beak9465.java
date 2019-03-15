package dp;

import java.util.Scanner;

public class Beak9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			long[][] arr = new long[n + 1][2];
			long[][] d = new long[n + 1][3];

			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					arr[j][i] = sc.nextInt();
				}
			}

			for (int i = 1; i <= n; i++) {
				d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + arr[i][0];
				d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + arr[i][1];
			}

			long ans = 0;

			ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));

			System.out.println(ans);
		}

		sc.close();
	}
}
