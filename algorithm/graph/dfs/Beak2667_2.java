package graph.dfs;

import java.util.*;
import java.io.*;

public class Beak2667_2 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] arr;
	static int[][] visit;
	static int n;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void dfs(int v, int x, int cnt) {
		visit[v][x] = cnt;

		for (int i = 0; i < dx.length; i++) {
			int nx = dx[i] + v;
			int ny = dy[i] + x;
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (arr[nx][ny] == 1 && visit[nx][ny] == 0) {
					dfs(nx, ny, cnt);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++)
				arr[i][j] = str.charAt(j) - '0';
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && visit[i][j] == 0) {
					dfs(i, j, ++cnt);
				}
			}
		}

		int ans[] = new int[cnt];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] != 0) {
					ans[visit[i][j] - 1]++;
				}
			}
		}

		Arrays.sort(ans);
		System.out.println(cnt);
		
		for (int i : ans) {
			System.out.println(i);
		}
	}
}
