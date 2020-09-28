package graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Beak12851 {
	static class Pair {
		int x;
		int count;

		Pair(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	static final int MAX = 100000;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		boolean check[] = new boolean[MAX + 1];

		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			System.exit(0);
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		queue.add(new Pair(n, 0));

		while (!queue.isEmpty()) {
			Pair now = queue.remove();
			int x = now.x;
			int count = now.count;
			check[x] = true;
			if (x == k) {
				if (map.get(count) == null)
					map.put(count, 1);
				else
					map.put(count, map.get(count) + 1);
				if (MIN > count)
					MIN = count;
			}

			if (x - 1 >= 0 && x <= MAX)
				if (!check[x - 1])
					queue.add(new Pair(x - 1, count + 1));

			if (x + 1 <= MAX)
				if (!check[x + 1])
					queue.add(new Pair(x + 1, count + 1));

			if (x * 2 <= MAX)
				if (!check[x * 2])
					queue.add(new Pair(x * 2, count + 1));

		}

		System.out.println(MIN);
		System.out.println(map.get(MIN));

		sc.close();
	}
}
