package bruteForce;

import java.util.*;
import java.io.*;

public class Beak2798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Integer arr[] = new Integer[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr, Collections.reverseOrder());

		int max = 0;
		loop1: for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum == m) {
						max = sum;
						break loop1;
					}

					if (sum <= m && max < sum)
						max = sum;
				}
			}
		}

		System.out.println(max);

	}

}
