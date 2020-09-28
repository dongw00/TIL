package graph.dfs;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Beak14502 {
	static int n;
	static int m;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int arr[][];
	static int copy[][];
	static int check[][];
	static List<Point> virus = new ArrayList<Point>();
	static int MAX = Integer.MIN_VALUE;

	// 백트래킹을 이용해 3개의 벽 세우기
	private static void setWall(int start, int depth) {
		if (depth == 3) {
			copyMap();

			for (Point p : virus)
				spreadVirus(p.x, p.y);

			MAX = Math.max(MAX, getSafeArea());
			return;
		}

		for (int i = start; i < n * m; i++) {
			int x = i / m;
			int y = i % m;

			if (arr[x][y] == 0) {
				arr[x][y] = 1;
				setWall(i + 1, depth + 1);
				arr[x][y] = 0;
			}
		}
	}

	private static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	private static void spreadVirus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					spreadVirus(nx, ny);
				}
			}
		}
	}

	private static int getSafeArea() {
		int safe = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 0)
					safe++;
			}
		}
		return safe;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		setWall(0, 0);
		System.out.println(MAX);
	}
}
