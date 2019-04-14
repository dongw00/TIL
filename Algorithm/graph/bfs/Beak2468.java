package graph.bfs;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Beak2468 {
	static int[][] arr;
	static int[][] check;
	static int n;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int MAX = Integer.MIN_VALUE;
	static int MAX_RAIN = Integer.MIN_VALUE;

	private static void dfs(int x, int y, int count, int height) {
		check[x][y] = count;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (arr[nx][ny] > height && check[nx][ny] == 0)
					dfs(nx, ny, count, height);
			}
		}
	}

	private static void bfs(int x, int y, int count, int height) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		check[x][y] = count;

		while (!queue.isEmpty()) {
			Point point = queue.remove();

			for (int i = 0; i < dx.length; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (arr[nx][ny] > height && check[nx][ny] == 0) {
						queue.add(new Point(nx, ny));
						check[nx][ny] = count;
						// bfs(nx, ny, count, height);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (MAX_RAIN < arr[i][j])
					MAX_RAIN = arr[i][j];
			}

		}

		for (int k = 0; k < MAX_RAIN; k++) {
			int count = 0;
			check = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					if (arr[i][j] > k && check[i][j] == 0)
						dfs(i, j, ++count, k);
				// bfs(i, j, ++count, k);
			}
			if (MAX < count)
				MAX = count;
		}

		System.out.println(MAX);
	}
}
