package graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak11724 {
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		list = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++)
			list[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			list[u].add(v);
			list[v].add(u);
		}

		check = new boolean[n + 1];

		/* DFS 방법 */
		for (int i = 1; i < n + 1; i++) {
			if (!check[i]) {
				count++;
				for (int j = 0; j < list[i].size(); j++) {
					dfs(list[i].get(j));
				}
			}
		}

		/* BFS 방법 */
		for (int i = 1; i < n + 1; i++) {
			if (!check[i]) {
				count++;
				for (int j = 0; j < list[i].size(); j++) {
					bfs(list[i].get(j));
				}
			}
		}

		System.out.println(count);

		sc.close();
	}

	private static void dfs(int x) {
		if (check[x]) {
			return;
		}
		check[x] = true;

		for (int y : list[x]) {
			if (!check[y]) {
				dfs(y);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int y : list[x]) {
				if (!check[y]) {
					check[y] = true;
					queue.add(y);
				}
			}
		}

	}
}
