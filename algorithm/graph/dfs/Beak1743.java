package graph.dfs;

import java.io.*;
import java.util.*;

public class Beak1743 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] arr = new int[101][101];
	static boolean[][] visit = new boolean[101][101];
	static int n, m, cnt, max;

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		cnt++;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (1 <= nx && nx <= n && 1 <= ny && ny <= m) {
				if (arr[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					max = Math.max(cnt, max);
					cnt = 0;
					dfs(i, j);
				}
			}
		}
		max = Math.max(cnt, max);
		System.out.println(max);
	}
}
