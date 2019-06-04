package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = arr[i] * (n - i);
			if (max < arr[i])
				max = arr[i];
		}

		System.out.println(max);
	}
}
