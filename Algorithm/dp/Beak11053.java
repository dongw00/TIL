package dp;

import java.util.Scanner;

public class Beak11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		int d[] = new int[n + 1];

		d[1] = 1;

		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		for (int i = 2; i <= n; i++) {
			d[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && d[i] <= d[j])
					d[i] = d[j] + 1;
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++)
			max = Math.max(d[i], max);

		System.out.println(max);

		sc.close();
	}
}
