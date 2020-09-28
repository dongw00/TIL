package searching;

import java.util.Scanner;

public class Beak2512 {
	static int MAX = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (MAX < arr[i])
				MAX = arr[i];
		}

		int m = sc.nextInt();

		int start = 1;
		int last = MAX;
		long maxAmount = 0;
		int ans = 0;
		while (start <= last) {
			int mid = (start + last) / 2;
			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (mid <= arr[i])
					sum += mid;
				else
					sum += arr[i];
			}

			if (sum > m)
				last = mid - 1;
			else {
				start = mid + 1;
				if (maxAmount < sum && sum <= m) {
					maxAmount = sum;
					ans = mid;
				}
			}

		}

		System.out.println(ans);

		sc.close();
	}
}
