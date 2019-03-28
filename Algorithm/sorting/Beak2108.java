package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] = Integer.parseInt(br.readLine());
			
			/*
			if (arr[i] >= 0)
				pCount[arr[i]]++;
			else
				nCount[arr[i]]++;
			*/
		}

		Arrays.sort(arr);

		// 산술평균
		System.out.println(sum / n);
		// 중앙값
		System.out.println(arr[n / 2]);
		// 최빈값
		// System.out.println(count[n - 2]);
		// 차이
		System.out.println(arr[n - 1] - arr[0]);
	}
}
