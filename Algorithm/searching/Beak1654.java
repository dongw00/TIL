package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1654 {
	static int MAX = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);

		long start = 1;
		long end = arr[n - 1];
		long mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			long sum = 0;
			
			for (int i = 0; i < arr.length; i++)
				sum += (arr[i] / mid);
			
			if (m <= sum)
				start = mid + 1;
			else if (m > sum)
				end = mid - 1;
		}
		
		System.out.println(end);
	}
}
