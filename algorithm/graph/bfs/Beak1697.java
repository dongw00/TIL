package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak1697 {
	static final int MAX = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean check[] = new boolean[MAX + 1];
		int dist[] = new int[MAX + 1];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		check[n] = true;

		while (!queue.isEmpty()) {
			int now = queue.remove();
			if (now == k) {
				System.out.println(dist[now]);
				break;
			}
			if (now - 1 >= 0) {
				if (!check[now - 1]) {
					queue.add(now - 1);
					check[now - 1] = true;
					dist[now - 1] = dist[now] + 1;
				}
			}
			if (now + 1 <= MAX) {
				if (!check[now + 1]) {
					queue.add(now + 1);
					check[now + 1] = true;
					dist[now + 1] = dist[now] + 1;
				}
			}
			if (now * 2 <= MAX) {
				if (!check[now * 2]) {
					queue.add(now * 2);
					check[now * 2] = true;
					dist[now * 2] = dist[now] + 1;
				}
			}
		}
		sc.close();
	}
}
