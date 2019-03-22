package graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak2644 {
	static class Pair {
		int x;
		int count;

		Pair(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int p1 = sc.nextInt();
		int p2 = sc.nextInt();

		int m = sc.nextInt();

		LinkedList<Integer> adj[] = new LinkedList[n + 1];
		boolean[] check = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adj[i] = new LinkedList();
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(p2, 0));
		check[p2] = true;

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			int x = pair.x;
			int count = pair.count;

			if (x == p1) {
				System.out.println(count);
				System.exit(0);
			}

			Iterator<Integer> i = adj[x].listIterator();
			while (i.hasNext()) {
				int nx = i.next();
				if (!check[nx]) {
					queue.add(new Pair(nx, count + 1));
					check[nx] = true;
				}
			}
		}

		System.out.println(-1);

		sc.close();
	}
}
