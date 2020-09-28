package sorting;

import java.io.*;
import java.util.*;

public class Beak11651 {
	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.y < o.y)
				return -1;
			else if (this.y == o.y) {
				if (this.x < o.x)
					return -1;
				else if (this.x == o.x)
					return 0;
				else
					return 1;
			} else
				return 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Pair[] p = new Pair[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			p[i] = new Pair(x, y);
		}

		Arrays.sort(p);

		for (Pair i : p)
			System.out.print(i.x + " " + i.y + "\n");
	}

}
