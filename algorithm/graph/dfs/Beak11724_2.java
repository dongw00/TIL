package graph.dfs;

import java.io.*;
import java.util.*;

public class Beak11724_2 {
	static int n;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[b][a] = 1;
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void dfs(int v) {
		visit[v] = true;

		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}
