package graph.MST.Kruskal;

import java.util.*;
import java.io.*;

public class Beak1197 {
	static class Edge implements Comparable<Edge> {
		int v1, v2, cost;

		Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost)
				return -1;
			else if (this.cost == o.cost)
				return 0;
			else
				return 1;
		}
	}

	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			parent[y] = x;
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, c));
		}

		parent = new int[v + 1];

		for (int i = 1; i <= v; i++)
			parent[i] = i;

		Collections.sort(edgeList);

		int sum = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (!isSameParent(edge.v1, edge.v2)) {
				sum += edge.cost;
				union(edge.v1, edge.v2);
			}
		}

		System.out.println(sum);
	}

}
