package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak1697 {
	public static final int MAX = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		boolean check[] = new boolean[MAX];
		int dist[] = new int[MAX];
		queue.add(n);
		check[n] = true;
		dist[n] = 0;

		while (!queue.isEmpty()) {
			int val = queue.remove();

			if (val - 1 >= 0) {
				if (!check[val - 1]) {
					queue.add(val - 1);
					check[val - 1] = true;
					dist[val - 1] = dist[val] + 1;
				}
			}
			if (val + 1 < MAX) {
				if (!check[val + 1]) {
					queue.add(val + 1);
					check[val + 1] = true;
					dist[val + 1] = dist[val] + 1;
				}
			}
			if (val * 2 < MAX) {
				if (!check[val * 2]) {
					queue.add(val * 2);
					check[val * 2] = true;
					dist[val * 2] = dist[val] + 1;
				}
			}
		}

		System.out.println(dist[k]);

		sc.close();
	}
}
