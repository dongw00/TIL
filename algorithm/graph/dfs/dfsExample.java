package graph.dfs;

import java.io.*;
import java.util.*;

public class dfsExample {
	static ArrayList<Integer>[] list;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		check = new boolean[n + 1];

		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i < n + 1; i++)
			Collections.sort(list[i]);

		dfs(start);

		br.close();
	}

	private static void dfs(int x) {
		if (check[x])
			return;

		check[x] = true;

		System.out.println(x + " ");
		for (int y : list[x]) {
			if (!check[y])
				dfs(y);
		}
	}
}
