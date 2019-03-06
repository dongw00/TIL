package graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

class Edge {
	int from, to;

	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

public class Beak13023 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] check = new boolean[n][n];
		ArrayList<Integer>[] g = new ArrayList[n];
		ArrayList<Edge> edges = new ArrayList<Edge>();

		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges.add(new Edge(from, to));
			edges.add(new Edge(to, from));
			check[from][to] = check[to][from] = true;
			g[from].add(to);
			g[to].add(from);
		}

		m *= 2;

		for (int i = 0; i < m; i++) {
			int A = edges.get(i).from;
			int B = edges.get(i).to;

			for (int j = 0; j < m; j++) {
				int C = edges.get(j).from;
				int D = edges.get(j).to;
				if (A == B || A == C || A == D || B == C || B == D || C == D) {
					continue;
				}
				if (!check[B][C])
					continue;
				for (int E : g[D]) {
					if (A == E || B == E || C == E || D == E) {
						continue;
					}
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		System.out.println(0);

		sc.close();
	}

}
