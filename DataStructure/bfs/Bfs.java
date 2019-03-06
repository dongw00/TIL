package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	private static void bfs(int[][] a, boolean[] c, int v) {
		Queue<Integer> queue = new LinkedList<>();
		int n = a.length - 1;
		
		queue.add(v);
		c[v] = true;
		
		while (!queue.isEmpty()) {
			v = queue.poll();
			System.out.println(v + " ");
			
			for (int i = 1; i <= n; i++) {
				if (a[v][i] == 1 && !c[i]) {
					queue.add(i);
					c[i] = true;
				}
			}
		}
	}
}
