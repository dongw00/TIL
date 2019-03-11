package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Beak2178 {
	static int[][] arr;
	static boolean[][] check;
	static int[][] dist;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs(int x, int y, int count, int n, int m) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		check[x][y] = true;
		dist[x][y] = count;

		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			x = p.x;
			y = p.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (arr[nx][ny] == 1 && !check[nx][ny]) {
						queue.add(new Pair(nx, ny));
						dist[nx][ny] = dist[x][y] + 1;
						check[nx][ny] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str1 = br.readLine().split(" ");

		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String val = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = val.charAt(j) - '0';
			}
		}

		int count = 0;
		check = new boolean[n][m];
		dist = new int[n][m];

		bfs(0, 0, ++count, n, m);

		System.out.println(dist[n - 1][m - 1]);
	}
}
