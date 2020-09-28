package graph.bfs;

import java.io.*;
import java.util.*;

import java.awt.Point;

public class Beak17071 {
	static Queue<Point> queue;
	static HashMap<Integer, Boolean> map;
	static int m;
	static final int MAX = 500000;
	static final int dx[] = { 2, -1, 1 };
	static int boost = 1;
	static int MIN = Integer.MAX_VALUE;

	private static void bfs(int x, int count) {
		queue.add(new Point(x, count));

		while (!queue.isEmpty()) {
			Point point = queue.remove();
			x = point.x;
			count = point.y;

			if (m >= 500000)
				break;

			if (x == m + ((count * (count + 1) / 2))) {
				if (count < MIN)
					MIN = count;
			}

			if (0 <= x * 2 && x * 2 < MAX) {
				if (map.get(x * 2) == null || !map.get(x * 2)) {
					map.put(x * 2, true);
					queue.add(new Point(x * 2, count + 1));
				}
			}

			if (0 <= x - 1 && x - 1 < MAX) {
				if (map.get(x - 1) == null || !map.get(x - 1)) {
					map.put(x - 1, true);
					queue.add(new Point(x - 1, count + 1));
				}
			}
			if (0 <= x + 1 && x + 1 < MAX) {
				if (map.get(x + 1) == null || !map.get(x + 1)) {
					map.put(x + 1, true);
					queue.add(new Point(x + 1, count + 1));
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if (m >= 500000) {
			System.out.println(-1);
			System.exit(0);
		}

		queue = new LinkedList<Point>();
		map = new HashMap<Integer, Boolean>();

		bfs(n, 0);
		
		if (MIN == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(MIN);
	}
}
