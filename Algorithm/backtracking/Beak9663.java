package backtracking;

import java.io.*;
import java.util.*;

public class Beak9663 {
	class nQueen {
		private int n;
		private int cols[];

		public nQueen(int n) {
			this.n = n;
			cols = new int[n];
		}

		private void backTracking(int level) {
			if (level == n) {
				for (int i = 0; i < n; i++)
					System.out.print(cols[i]);
				System.out.println();
			} else {
				for (int i = 0; i < n; i++) {
					cols[level] = i;
					if (isPossible(level))
						backTracking(level + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
	}
}
