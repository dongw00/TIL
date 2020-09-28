package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Three {
	int x;
	int y;
	int z;

	Three(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Beak7569 {
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();

		Queue<Three> queue = new LinkedList<Three>();

		int[][][] arr = new int[h][n][m];
		int[][][] dist = new int[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = sc.nextInt();
					if (arr[k][i][j] == 1)
						queue.add(new Three(k, i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Three t = queue.remove();
			int x = t.x;
			int y = t.y;
			int z = t.z;
			for (int i = 0; i < dy.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m) {
					if (arr[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
						queue.add(new Three(nx, ny, nz));
						dist[nx][ny][nz] = dist[x][y][z] + 1;
					}
				}
			}
		}

		int ans = 0;

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (ans < dist[k][i][j])
						ans = dist[k][i][j];
				}
			}
		}

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[k][i][j] == 0 && dist[k][i][j] == 0) {
						ans = -1;
					}
				}
			}
		}

		System.out.println(ans);

		sc.close();
	}
}
