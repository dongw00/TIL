package bp;

import java.io.*;

public class Beak9663 {
	static int[] col;
	static int count = 0;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		col = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			col[1] = i;
			nQueen(1);
		}

		System.out.println(count);
	}

	private static void nQueen(int row) {
		if (row == n)
			count++;
		else {
			for (int i = 1; i <= n; i++) {
				col[row + 1] = i;
				if (isPossible(row + 1))
					nQueen(row + 1);
				else
					col[row + 1] = 0;
			}
		}
		col[row] = 0;
	}

	private static boolean isPossible(int row) {
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row])
				return false;
			if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
				return false;
		}
		return true;
	}
}
