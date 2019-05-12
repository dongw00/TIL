package bp;

import java.io.*;
import java.util.*;

public class Beak1182_1 {
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

		dfs(arr, 0, 0, 0);
	}

	private static int dfs(int[] arr, int cnt, int sum, int length) {
		if (cnt == n) {
			if (sum == m && length != 0)
				cnt++;
			return 0;
		}

		dfs(arr, cnt + 1, sum + arr[cnt], length + 1);
		dfs(arr, cnt + 1, sum, length);

		return 0;
	}
}
