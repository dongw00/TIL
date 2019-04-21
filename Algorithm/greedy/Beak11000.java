package greedy;

import java.io.*;
import java.util.*;

public class Beak11000 {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.x == o2.x)
					return Integer.compare(o1.y, o2.y);
				else
					return Integer.compare(o1.x, o2.x);
			}
		};
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		Pair[] arr = new Pair[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[i] = new Pair(x, y);
		}

		Arrays.sort(arr, Pair.comparator);

		queue.add(arr[0].y);

		for (int i = 1; i < n; i++) {
			if (queue.peek() <= arr[i].x)
				queue.remove();
			queue.add(arr[i].y);
		}
		System.out.println(queue.size());
	}
}
