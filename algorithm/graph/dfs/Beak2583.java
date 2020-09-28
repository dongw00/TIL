package graph.dfs;

import java.io.*;
import java.util.*;

public class Beak2583 {
	static int m, n, area;
	static int[][] arr = new int[101][101];

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void setSquare(int lx, int ly, int rx, int ry) {
		for (int i = ly; i < ry; i++) {
			for (int j = lx; j < rx; j++) {
				arr[i][j] = 1;
			}
		}
	}

	private static void dfs(int x, int y) {
		arr[x][y] = 1;
		area++;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (arr[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			setSquare(x1, y1, x2, y2);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				area = 0;
				if (arr[i][j] == 0) {
					cnt++;
					dfs(i, j);
					pq.add(area);
				}
			}
		}

		System.out.println(cnt);

		while (!pq.isEmpty()) {
			System.out.print(pq.remove() + " ");
		}
	}
}
