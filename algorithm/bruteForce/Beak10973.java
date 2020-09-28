package bruteForce;

import java.util.Scanner;

public class Beak10973 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		previousPermutation(arr);

		sc.close();
	}

	private static void previousPermutation(int[] arr) {
		int n = arr.length;
		boolean b = true;
		Loop1: for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				for (int j = n - 1; j >= i; j--) {
					if (arr[j] < arr[i - 1]) {
						int temp = arr[i - 1];
						arr[i - 1] = arr[j];
						arr[j] = temp;
						int k = n - 1;
						while (i < k) {
							int temp2 = arr[i];
							arr[i] = arr[k];
							arr[k] = temp2;
							i++;
							k--;
						}
						b = false;
						break Loop1;
					}
				}
			}
		}
		if (b) {
			System.out.println(-1);
		} else {
			showArray(arr);
		}
	}

	private static void showArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
