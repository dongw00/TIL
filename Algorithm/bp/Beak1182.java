package bp;

import java.io.*;
import java.util.*;

public class Beak1182 {
	static int n, m;
	static int cnt, currentSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dfs(0, arr);

		System.out.println(cnt);
	}

	private static void dfs(int current, int[] arr) {
		if (current == n)
			return;
		if (currentSum + arr[current] == m)
			cnt++;

		dfs(current + 1, arr);

		currentSum += arr[current];
		dfs(current + 1, arr);

		currentSum -= arr[current];
	}
}
