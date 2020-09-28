package bruteForce;

import java.io.*;
import java.util.*;

public class Beak1987 {
	static char arr[][];
	static boolean check[];
	static int ans = 1;
	static int cnt = 1;
	static int n, m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		check = new boolean[26];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = (char) (str.charAt(j) - 'A');
			}
		}

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		int idx = arr[x][y];
		check[idx] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				int next = arr[nx][ny];

				if (!check[next]) {
					ans = Math.max(++cnt, ans);
					dfs(nx, ny);
				}
			}
		}

		--cnt;
		check[idx] = false;
	}
}
