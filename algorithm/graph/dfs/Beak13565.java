package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak13565 {
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int n;
	static int m;
	static int[][] arr;
	static boolean find = false;

	private static void dfs(int x, int y) {
		if (x == (n - 1))
			find = true;

		arr[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (arr[nx][ny] == 0 && !find)
					dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j) - '0';
		}

		for (int i = 0; i < m; i++) {
			if (arr[0][i] == 0 && !find)
				dfs(0, i);
		}

		if (find)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
