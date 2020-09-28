package bruteForce;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Beak2580 {
	static int[][] sudoku = new int[10][10];
	static ArrayList<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(str[j]);

				if (sudoku[i][j] == 0)
					list.add(new Point(i, j));
			}
		}

		for (int i = 1; i <= 9; i++) {
			int r = list.get(0).x;
			int c = list.get(0).y;

			if (check_vertical(c, i) && check_horizontal(r, i) && check_square(r, c, i)) {
				sudoku[r][c] = i;
				dfs(1);
				sudoku[r][c] = 0;
			}
		}
	}

	private static boolean check_vertical(int c, int i) {
		for (int r = 0; r < 9; r++)
			if (sudoku[r][c] == i)
				return false;
		return true;
	}

	private static boolean check_horizontal(int r, int i) {
		for (int c = 0; c < 9; c++)
			if (sudoku[r][c] == i)
				return false;
		return true;
	}

	private static boolean check_square(int r, int c, int i) {
		r /= 3;
		c /= 3;
		for (int nr = r * 3; nr < (r * 3) + 3; nr++) {
			for (int nc = (c * 3); nc < (c * 3) + 3; nc++)
				if (sudoku[nr][nc] == i)
					return false;
		}
		return true;
	}

	private static void dfs(int idx) {
		if (idx == list.size())
			print();

		for (int i = 1; i <= 9; i++) {
			int r = list.get(idx).x;
			int c = list.get(idx).y;

			if (check_vertical(c, i) && check_horizontal(r, i) && check_square(r, c, i)) {
				sudoku[r][c] = i;
				dfs(idx + 1);
				sudoku[r][c] = 0;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(sudoku[i][j] + " ");
			System.out.println();
		}
		System.exit(0);
	}
}
