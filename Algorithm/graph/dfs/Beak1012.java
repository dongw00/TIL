package graph.dfs;

import java.util.*;
import java.io.*;

public class Beak1012 {
	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] arr;
	static int[][] visit;
	static int m, n;

	private static void dfs(int x, int y, int cnt) {
		visit[x][y] = cnt;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (arr[nx][ny] == 1 && visit[nx][ny] == 0) {
					dfs(nx, ny, cnt);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr = new int[n][m];
			visit = new int[n][m];
			int cnt = 1;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b][a] = 1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && visit[i][j] == 0)
						dfs(i, j, cnt++);
				}
			}

			System.out.println(cnt - 1);
		}
	}

}
