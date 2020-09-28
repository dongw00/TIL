package graph.bfs;

import java.io.*;
import java.util.*;

public class Beak7576_2 {
	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];
		int dist[][] = new int[n][m];

		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					queue.add(new Pair(i, j));
			}
		}

		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] == 0 && dist[nx][ny] == 0) {
						queue.add(new Pair(nx, ny));
						dist[nx][ny] += dist[p.x][p.y] + 1;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && dist[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				ans = Math.max(ans, dist[i][j]);
			}
		}

		System.out.println(ans);
	}
}
