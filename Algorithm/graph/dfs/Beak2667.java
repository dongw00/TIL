package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

public class Beak2667 {
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };
	static int[][] arr;
	static int n;
	static int check[][];

	private static void dfs(int x, int y, int count) {
		check[x][y] = count;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
					dfs(nx, ny, count);
				}
			}
		}
	}

	private static void bfs(int x, int y, int count) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(x, y));
		check[x][y] = count;
		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			x = p.x;
			y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
						queue.add(new Pair(nx, ny));
						check[nx][ny] = count;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int count = 0;
		check = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && check[i][j] == 0) {
					//dfs(i, j, ++count);
					bfs(i, j, ++count);
				}
			}
		}
		int[] ans = new int[count];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j] != 0) {
					ans[check[i][j] - 1]++;
				}
			}
		}

		Arrays.sort(ans);

		System.out.println(count);
		for (int i : ans) {
			System.out.println(i);
		}
	}
}
