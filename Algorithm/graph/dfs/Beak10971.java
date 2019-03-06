package graph.dfs;

import java.util.Scanner;

public class Beak10971 {
	static int n;
	static int MIN = Integer.MAX_VALUE;
	static int[][] w;
	static boolean check[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = new int[n][n];
		check = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				w[i][j] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			dfs(i, i, 0, 0);
		}

		System.out.println(MIN);

		sc.close();
	}

	private static void dfs(int start, int y, int sum, int cnt) {
		// 모든 도시를 거치고, 다시 start 지점으로 온 경우
		if (cnt == n && start == y) {
			MIN = Math.min(MIN, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (w[y][i] == 0)
				continue;

			// 방문하지 않았을 때
			if (!check[y] && w[y][i] > 0) {
				check[y] = true;
				sum += w[y][i];

				if (sum <= MIN) {
					dfs(start, i, sum, cnt + 1);
				}

				// 방문 기록과 합 초기화
				check[y] = false;
				sum -= w[y][i];
			}
		}
	}
}
