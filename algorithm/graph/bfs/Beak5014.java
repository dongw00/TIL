package graph.bfs;

import java.util.*;
import java.io.*;

public class Beak5014 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		int arr[] = { -d, u };
		int dist[] = new int[f + 1];
		boolean check[] = new boolean[f + 1];

		queue.add(s);
		check[s] = true;

		if (s == g) {
			System.out.println(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) {
			int here = queue.remove();

			for (int i = 0; i < 2; i++) {
				int ns = here + arr[i];

				if (0 < ns && ns <= f) {
					if (!check[ns]) {
						queue.add(ns);
						check[ns] = true;
						dist[ns] = dist[here] + 1;
					}
				}
			}
		}

		if (dist[g] != 0)
			System.out.println(dist[g]);
		else
			System.out.println("use the stairs");
	}
}
