package binarySearch;

import java.io.*;
import java.util.*;

public class Beak2805_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0, e = 2000000001;

		while (s + 1 < e) {
			int mid = (s + e) / 2;

			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (arr[i] > mid)
					sum += arr[i] - mid;
			}

			if (sum >= m)
				s = mid;
			else
				e = mid;
		}

		System.out.println(s);
	}

}
