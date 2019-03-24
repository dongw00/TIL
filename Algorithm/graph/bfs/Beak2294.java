package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class Beak2294 {
	static int[] dx;
	static int[] arr;
	static boolean[] check;
	static int k;
	static int MIN = Integer.MAX_VALUE;
	static int MAX = 10000;
	static Queue<Point> queue;

	private static void bfs(int x, int count) {
		queue.add(new Point(x, count));
		check[x] = true;

		while (!queue.isEmpty()) {
			Point point = queue.remove();
			x = point.x;
			count = point.y;

			if (x == 0) {
				if (MIN > count)
					MIN = count;
			}
			if (MIN < count) {
				continue;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				if (0 <= nx && nx <= k) {
					if (!check[nx]) {
						queue.add(new Point(nx, count + 1));
						check[nx] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		k = sc.nextInt();

		dx = new int[n];
		check = new boolean[MAX + 1];
		queue = new LinkedList<Point>();

		for (int i = 0; i < n; i++)
			dx[i] = -(sc.nextInt());

		bfs(k, 0);

		if (MIN == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(MIN);

		sc.close();
	}
}
