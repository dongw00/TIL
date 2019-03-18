package dp;

import java.util.Scanner;

public class Beak11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int d1[] = new int[n];
		int d2[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			d1[i] = 1;
			d2[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && d1[i] <= d1[j])
					d1[i] = d1[j] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j] && d2[i] <= d2[j])
					d2[i] = d2[j] + 1;
			}
		}

		int ans = d1[0] + d2[0] - 1;
		for (int i = 1; i < n; i++) {
			if (ans < d1[i] + d2[i] - 1)
				ans = d1[i] + d2[i] - 1;
		}

		System.out.println(ans);

		sc.close();
	}
}
