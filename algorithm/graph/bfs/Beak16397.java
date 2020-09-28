package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beak16397 {
	static final int MAX = 99999;

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
		int t = sc.nextInt();
		int g = sc.nextInt();

		if (n == g) {
			System.out.println(0);
			System.exit(0);
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		boolean check[] = new boolean[MAX + 1];
		queue.add(new Pair(n, 0));
		check[n] = true;

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			int x = pair.x;
			int count = pair.count;

			if (count > t) {
				System.out.println("ANG");
				System.exit(0);
			}
			if (x == g) {
				System.out.println(count);
				System.exit(0);
			}

			if (x + 1 <= MAX) {
				if (!check[x + 1]) {
					queue.add(new Pair(x + 1, count + 1));
					check[x + 1] = true;
				}
			}

			if (x * 2 <= MAX) {
				int digit = 0;
				int temp = x * 2;
				while (temp != 0) {
					digit++;
					temp /= 10;
				}
				digit = (int) Math.pow(10, digit - 1);
				if (!check[(x * 2) - digit]) {
					queue.add(new Pair(x * 2 - digit, count + 1));
					check[x * 2 - digit] = true;
				}
			}
		}
		System.out.println("ANG");

		sc.close();
	}
}
