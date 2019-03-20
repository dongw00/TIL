package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak13549 {
	static final int MAX = 100000;
	static int MIN = Integer.MAX_VALUE;

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
		int k = sc.nextInt();

		boolean[] check = new boolean[MAX + 1];
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(n, 0));
		check[n] = true;

		if (n == k) {
			System.out.println(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			int x = pair.x;
			int count = pair.count;

			if (x == k) {
				if (MIN > count)
					MIN = count;
			}

			if (0 <= x * 2 && x * 2 <= MAX) {
				if (!check[x * 2]) {
					queue.add(new Pair(x * 2, count));
					check[x * 2] = true;
				}
			}

			if (0 <= x - 1 && x - 1 <= MAX) {
				if (!check[x - 1]) {
					queue.add(new Pair(x - 1, count + 1));
					check[x - 1] = true;
				}
			}
			if (0 <= x + 1 && x + 1 <= MAX) {
				if (!check[x + 1]) {
					queue.add(new Pair(x + 1, count + 1));
					check[x + 1] = true;
				}
			}
		}

		System.out.println(MIN);

		sc.close();
	}
}
