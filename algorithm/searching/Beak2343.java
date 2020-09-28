package searching;

import java.util.Scanner;

public class Beak2343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int arr[] = new int[n];

		int sum = 0;

		for (int i = 0; i < n; i++)
			sum += arr[i] = sc.nextInt();

		int start = 0;
		int last = sum;

		while (start <= last) {
			int mid = (start + last) / 2;

			int idx = 0;
			int d[] = new int[m];

			for (int i = 0; i < n; i++) {
				if (d[idx] + arr[i] <= mid)
					d[idx] += arr[i];
				else {
					idx++;
					i--;
					if (idx == m)
						break;
				}
			}

			if (idx < m)
				last = mid - 1;
			else
				start = mid + 1;
		}

		System.out.println(start);

		sc.close();
	}
}
