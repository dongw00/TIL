package graph.MST;

import java.io.*;
import java.util.*;

public class Beak9372 {
	static class Edge {
		int v1, v2;

		Edge(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}

	static int[] parent;
	static ArrayList<Edge> edgeList;

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y)
			parent[y] = x;
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	private static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			edgeList = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(a, b));
			}

			for (int i = 1; i <= n; i++)
				parent[i] = i;

			int count = 0;
			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);

				if (!isSameParent(edge.v1, edge.v2)) {
					count++;
					union(edge.v1, edge.v2);
				}
			}

			System.out.println(count);
		}

	}

}
