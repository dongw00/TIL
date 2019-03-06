package bp.permutation;

import java.util.Scanner;

public class Beak10971 {
	static int MIN = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		int[] d = new int[n];

		int factorial = 1;
		for (int i = 0; i < n; i++) {
			d[i] = i;
			factorial *= (i + 1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		}
		nextPermutation(d, factorial);
		System.out.println(MIN);

		sc.close();
	}

	private static void nextPermutation(int[] d, int factorial) {
		int n = d.length - 1;
		tour(d);
		for (int l = 0; l < factorial; l++) {
			Loop1: for (int i = n; i > 0; i--) {
				if (d[i - 1] < d[i]) {
					for (int j = n; j >= i; j--) {
						if (d[j] > d[i - 1]) {
							int temp = d[i - 1];
							d[i - 1] = d[j];
							d[j] = temp;
							int k = n;
							while (i < k) {
								int temp2 = d[i];
								d[i] = d[k];
								d[k] = temp2;
								k--;
								i++;
							}
							if (d[0] == 1)
								tour(d);
							break Loop1;
						}
					}
				}
			}
		}
	}

	private static void tour(int[] d) {
		boolean ok = true;
		int sum = 0;
		for (int i = 0; i < d.length - 1; i++) {
			if (arr[d[i]][d[i + 1]] == 0) {
				ok = false;
			} else {
				sum += arr[d[i]][d[i + 1]];
			}
		}

		if (ok && arr[d[d.length - 1]][d[0]] != 0) {
			sum += arr[d[d.length - 1]][d[0]];
			MIN = Math.min(sum, MIN);
		}
	}
}
