package dp;

import java.util.Scanner;

public class Beak14002 {
	static int[] v;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		arr = new int[n];
		int d[] = new int[n];
		v = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			d[i] = 1;
			v[i] = -1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
					v[i] = j;
				}
			}
		}

		int max = 0;
		int p = 0;
		for (int i = 0; i < n; i++) {
			if (max < d[i]) {
				max = d[i];
				p = i;
			}
		}

		System.out.println(max);
		go(p);
		System.out.println();

		sc.close();
	}

	private static void go(int p) {
		if (p == -1)
			return;
		go(v[p]);
		System.out.print(arr[p] + " ");
	}
}
