package graph.bfs;

import java.io.*;
import java.util.*;

public class Beak11403 {
	static int[][] arr;
	static int[][] check;
	static int[][] resultB; // BFS 결과 값
	static int n;

	private static void dfs(int a, int b) {
		for (int i = 0; i < n; i++) {
			if (arr[a][i] == 1 && check[b][i] == 0) {
				check[b][i] = 1;
				dfs(i, b);
			}
		}
	}

	private static void bfs() {
		for (int i = 0; i < n; i++) {
			Queue<Integer> queue = new LinkedList<>();
			boolean checkB[] = new boolean[n];
			queue.add(i);

			while (!queue.isEmpty()) {
				int x = queue.remove();
				for (int j = 0; j < n; j++) {
					if (arr[x][j] == 1 && !checkB[j]) {
						queue.add(j);
						checkB[j] = true;
						resultB[i][j] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		check = new int[n][n];
		resultB = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();

		for (int i = 0; i < n; i++) {
			// dfs(i, i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// System.out.print(check[i][j] + " ");
				System.out.print(resultB[i][j] + " ");
			}
			System.out.println();
		}
	}
}
