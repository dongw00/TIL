package greedy;

import java.io.*;
import java.util.*;

public class Beak11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int temp = 0;
			for (int j = 0; j < i; j++) {
				temp += arr[j];
			}
			sum += (temp + arr[i]);
		}
		System.out.println(sum);
	}
}
