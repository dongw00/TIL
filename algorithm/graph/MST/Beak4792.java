package graph.MST;

import java.util.*;
import java.io.*;

public class Beak4792 {
	static class Edge {
		int v1, v2;
		int color;

		Edge(int v1, int v2, int color) {
			this.v1 = v1;
			this.v2 = v2;
			this.color = color;
		}
	}

	static int parent[];
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

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0 && k == 0)
				break;

			parent = new int[n + 1];
			edgeList = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				String str = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				edgeList.add(new Edge(a, b, str.equals("B") ? 1 : 2));
			}

			for (int i = 1; i <= n; i++)
				parent[i] = i;

			// red first
			edgeList.sort((e1, e2) -> e2.color - e1.color);

			int redCount = 0;
			int cnt = 0;
			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);

				if (!isSameParent(edge.v1, edge.v2)) {
					if (edge.color == 1)
						redCount++;
					cnt++;
					union(edge.v1, edge.v2);
					if (cnt == n - 1)
						break;
				}
			}

			int blueCount = 0;
			cnt = 0;
			for (int i = 1; i <= n; i++)
				parent[i] = i;

			// blue first
			edgeList.sort((e1, e2) -> e1.color - e2.color);

			for (int i = 0; i < edgeList.size(); i++) {
				Edge edge = edgeList.get(i);

				if (!isSameParent(edge.v1, edge.v2)) {
					if (edge.color == 1)
						blueCount++;
					union(edge.v1, edge.v2);
					if (cnt == n - 1)
						break;
				}
			}

			if (redCount <= k && k <= blueCount)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
