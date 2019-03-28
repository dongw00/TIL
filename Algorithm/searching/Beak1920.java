package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(str[i]);

		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];

		str = br.readLine().split(" ");
		for (int i = 0; i < m; i++)
			arr2[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(arr, arr2[i]) >= 0)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
