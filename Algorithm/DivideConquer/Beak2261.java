package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Beak2261 {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p) {
			return x < p.y && y > p.y ? 1 : -1;
		}
	}

	static class ComparatorDescending implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if (p1.x < p2.x)
				return -1;
			else if (p1.x == p2.x)
				return 0;
			else
				return 1;
		}
	}

	static class ComparatorSet implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if (p1.y == p2.y) {
				if (p1.x < p2.x)
					return -1;
				else if (p1.x == p2.x)
					return 0;
				else
					return 1;
			} else
				return p1.y < p2.y ? 1 : -1;
		}
	}

	private static int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		TreeSet<Point> candidate = new TreeSet<Point>(new ComparatorSet());
		int ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new ComparatorDescending());

		candidate.add(list.get(0));
		candidate.add(list.get(1));
		ans = distance(list.get(0), list.get(1));

		int start = 0;
		for (int i = 2; i < n; i++) {
			Point now = list.get(i);

			while (start < i) {
				Point pivot = list.get(start);
				int x = pivot.x - now.x;

				if (x * x > ans) {
					candidate.remove(pivot);
					start++;
				} else
					break;
			}
			int d = (int) Math.sqrt((double) ans) + 1;
			Point lower_point = new Point(now.y - d, now.y + d);
			SortedSet<Point> lower = candidate.tailSet(lower_point);
			Iterator<Point> it_lower = lower.iterator();

			while (it_lower.hasNext()) {
				Point p = it_lower.next();
				d = distance(now, p);
				if (d < ans)
					ans = d;
			}
			candidate.add(list.get(i));
		}
		System.out.println(ans);
	}
}
