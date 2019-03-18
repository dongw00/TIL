package dp;

import java.util.Scanner;

public class Beak1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++)
			d[i] = a[i] = sc.nextInt();

		int max = a[0];

		for (int i = 1; i < n; i++) {
			if (a[i] < d[i - 1] + a[i])
				d[i] = d[i - 1] + a[i];
			if (max < d[i])
				max = d[i];
		}

		System.out.println(max);

		sc.close();
	}
}
