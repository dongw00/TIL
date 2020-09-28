package binarySearch;

import java.io.*;
import java.util.*;

public class Beak2343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());

		int sum = 0;

		for (int i = 0; i < n; i++)
			sum += arr[i] = Integer.parseInt(st.nextToken());

		int min = 0;
		int max = sum;

		while (min <= max) {
			int mid = (min + max) / 2;

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
				max = mid - 1;
			else
				min = mid + 1;
		}

		System.out.println(min);
	}
}