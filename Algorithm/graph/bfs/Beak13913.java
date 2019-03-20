package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak13913 {
	static final int MAX = 100000;

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

		if (n == k) {
			System.out.println(0);
			System.out.println(n);
			System.exit(0);
		}

		boolean check[] = new boolean[MAX + 1];
		int d[] = new int[MAX + 1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(n, 0));
		check[n] = true;

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			int x = pair.x;
			int count = pair.count;

			if (x == k) {
				int idx = x;
				while (idx != n) {
					list.add(idx);
					idx = d[idx];
				}
				list.add(n);

				System.out.println(count);
			}

			if (0 <= x - 1 && x - 1 <= MAX) {
				if (!check[x - 1]) {
					queue.add(new Pair(x - 1, count + 1));
					check[x - 1] = true;
					d[x - 1] = x;
				}
			}
			if (0 <= x + 1 && x + 1 <= MAX) {
				if (!check[x + 1]) {
					queue.add(new Pair(x + 1, count + 1));
					check[x + 1] = true;
					d[x + 1] = x;
				}
			}
			if (0 <= x * 2 && x * 2 <= MAX) {
				if (!check[x * 2]) {
					queue.add(new Pair(x * 2, count + 1));
					check[x * 2] = true;
					d[x * 2] = x;
				}
			}
		}

		for (int i = list.size() - 1; i >= 0; i--)
			System.out.print(list.get(i) + " ");
		System.out.println();

		sc.close();
	}
}
