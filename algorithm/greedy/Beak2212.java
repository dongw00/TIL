package greedy;

import java.io.*;
import java.util.*;

public class Beak2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int arr[] = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int dist[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			dist[i] = arr[i + 1] - arr[i];
		}

		Arrays.sort(dist);

		int ans = 0;

		for (int i = 0; i < dist.length - k + 1; i++) {
			ans += dist[i];
		}

		System.out.println(ans);
	}
}
