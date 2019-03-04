package BruteForce.Permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Beak10819 {
	static int MAX = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int factorial = 1;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			factorial *= (i + 1);
		}
		Arrays.sort(arr);

		nextPermutation(arr, factorial);
		System.out.println(MAX);

		sc.close();
	}

	private static void nextPermutation(int[] arr, int factorial) {
		int n = arr.length - 1;
		calculate(arr);
		for (int l = 0; l < factorial; l++) {
			Loop1: for (int i = n; i > 0; i--) {
				if (arr[i - 1] < arr[i]) {
					for (int j = n; j >= i; j--) {
						if (arr[j] > arr[i - 1]) {
							int temp = arr[j];
							arr[j] = arr[i - 1];
							arr[i - 1] = temp;
							int k = n;
							while (i < k) {
								int temp2 = arr[i];
								arr[i] = arr[k];
								arr[k] = temp2;
								k--;
								i++;
							}
							calculate(arr);
							break Loop1;
						}
					}
				}
			}
		}

	}

	private static void calculate(int[] arr) {
		int value = 0;
		for (int i = 0; i < arr.length - 1; i++)
			value += Math.abs(arr[i] - arr[i + 1]);

		MAX = Math.max(value, MAX);
	}
}
