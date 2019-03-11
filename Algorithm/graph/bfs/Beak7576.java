package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair2 {
	int x;
	int y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Beak7576 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str1 = br.readLine().split(" ");

		int m = Integer.parseInt(str1[0]);
		int n = Integer.parseInt(str1[1]);

		int[][] arr = new int[n][m];
		int[][] dist = new int[n][m];

		Queue<Pair2> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] str2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = str2[j].charAt(0) - '0';
				if (arr[i][j] == 1) {
					queue.add(new Pair2(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair2 p = queue.remove();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (arr[nx][ny] == 0 && dist[nx][ny] == 0) {
						queue.add(new Pair2(nx, ny));
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, dist[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && dist[i][j] == 0) {
					ans = -1;
				}
			}
		}

		System.out.println(ans);
	}
}
