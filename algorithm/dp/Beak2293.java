package dp;

import java.util.Scanner;

public class Beak2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int arr[] = new int[n + 1];
		int d[] = new int[10001];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		d[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				if (j >= arr[i])
					d[j] += d[j - arr[i]];
			}
		}

		System.out.println(d[k]);

		sc.close();
	}
}
