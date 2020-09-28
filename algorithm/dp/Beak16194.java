package dp;

import java.util.Scanner;

public class Beak16194 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n + 1];
		int[] d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			d[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.min(d[i], d[i - j] + arr[j]);
			}
		}

		System.out.println(d[n]);

		sc.close();
	}
}
