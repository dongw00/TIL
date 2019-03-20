package bp;

import java.util.*;

public class Beak14888 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] op = new int[n - 1];
		int m = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++)
				op[m++] = i;
		}

		Arrays.sort(op);

		do {
			calc(arr, op);
		} while (nextPermutation(op));

		System.out.println(MAX);
		System.out.println(MIN);

		sc.close();
	}

	private static boolean nextPermutation(int[] op) {
		int i = op.length - 1;
		while (i > 0 && op[i - 1] >= op[i]) {
			i--;
		}

		if (i <= 0)
			return false;

		int j = op.length - 1;
		while (op[j] <= op[i - 1]) {
			j--;
		}

		int temp = op[i - 1];
		op[i - 1] = op[j];
		op[j] = temp;

		j = op.length - 1;
		while (i < j) {
			temp = op[i];
			op[i] = op[j];
			op[j] = op[i];
			i++;
			j--;
		}
		return true;
	}

	private static void calc(int[] arr, int[] op) {
		int n = arr.length;
		int ans = arr[0];

		for (int i = 1; i < n; i++) {
			if (op[i - 1] == 0) {
				ans = ans + arr[i];
			} else if (op[i - 1] == 1) {
				ans = ans - arr[i];
			} else if (op[i - 1] == 2) {
				ans = ans * arr[i];
			} else {
				ans = ans / arr[i];
			}
		}

		MAX = Math.max(ans, MAX);
		MIN = Math.min(ans, MIN);
	}
}
