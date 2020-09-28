package graph.dfs;

import java.util.*;

public class Beak1260 {
	static int[][] map;
	static boolean[] visit;
	static int n;

	private static void dfs(int i) {
		visit[i] = true;

		System.out.print(i + " ");
		for (int j = 1; j <= n; j++) {
			if (map[i][j] == 1 && !visit[j])
				dfs(j);
		}
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visit[i] = true;

		while (!queue.isEmpty()) {
			int tmp = queue.remove();
			System.out.print(tmp + " ");

			for (int j = 1; j <= n; j++) {
				if (map[tmp][j] == 1 && !visit[j]) {
					queue.add(j);
					visit[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a][b] = 1;
			map[b][a] = 1;
		}

		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);
		sc.close();
	}
}
