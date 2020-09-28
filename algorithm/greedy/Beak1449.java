package greedy;

import java.io.*;
import java.util.*;

public class Beak1449 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int count = 1;
		int temp = arr[0];
		for (int i = 0; i < N; i++) {
			if (temp + L - 1 < arr[i]) {
				temp = arr[i];
				count++;
			}
		}

		System.out.println(count);
	}
}
