package binarySearch;

import java.io.*;
import java.util.*;

public class Beak1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int arr[] = new int[k];

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long s = 1, e = arr[k - 1];

		while (s <= e) {
			long mid = (s + e) / 2;
			long cnt = 0;

			for (int i = 0; i < k; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= n) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(e);
	}
}
