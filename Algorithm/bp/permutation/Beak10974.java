package bp.permutation;

import java.util.Scanner;

public class Beak10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int factorial = 1;

		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
			factorial *= i;
			System.out.print(arr[i - 1] + " ");
		}
		System.out.println();

		nextPermutation(arr, factorial);

		sc.close();
	}

	private static void nextPermutation(int[] arr, int factorial) {
		int n = arr.length - 1;
		for (int i = 0; i < factorial; i++) {
			Loop1: for (int j = n; j > 0; j--) {
				if (arr[j - 1] < arr[j]) {
					for (int k = n; k >= j; k--) {
						if (arr[k] > arr[j - 1]) {
							int temp = arr[k];
							arr[k] = arr[j - 1];
							arr[j - 1] = temp;
							int l = n;
							while (j < l) {
								int temp2 = arr[j];
								arr[j] = arr[l];
								arr[l] = temp2;
								j++;
								l--;
							}
							showArray(arr);
							break Loop1;
						}
					}
				}
			}
		}
	}

	private static void showArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
