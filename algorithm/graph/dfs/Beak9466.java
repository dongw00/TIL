package graph.dfs;

import java.io.*;
import java.util.*;

public class Beak9466 {
	static int[] arr;
	static boolean[] visit, finish;
	static int cnt;

	private static void dfs(int v) {
		visit[v] = true;
		int next = arr[v];

		if (visit[next]) {
			if (!finish[next]) {
				for (int i = next; i != v; i = arr[i])
					cnt++;
				cnt++;
			}
		} else
			dfs(next);
		finish[v] = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			visit = new boolean[n];
			finish = new boolean[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			cnt = 0;
			for (int i = 0; i < n; i++) {
				if (!visit[i])
					dfs(i);
			}
			System.out.println(n - cnt);
		}
	}
}
