package greedy;

import java.io.*;
import java.util.*;

public class Beak2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int tempArr[] = new int[n - 1];

		for (int i = 1; i < n; i++)
			tempArr[i - 1] = arr[i] - arr[i - 1];

		Arrays.sort(tempArr);
		
		int sum = 0;
		
		for (int i = 0; i < tempArr.length - (k - 1); i++)
			sum += tempArr[i];

		System.out.println(sum);
	}
}
