package graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Beak1707 {
	static ArrayList<Integer> list[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		while (k-- > 0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			list = new ArrayList[v + 1];

			for (int i = 1; i <= v; i++)
				list[i] = new ArrayList<Integer>();

			for (int i = 0; i < e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				list[x].add(y);
				list[y].add(x);
			}

			int[] check = new int[v + 1];
			boolean b = true;

			for (int i = 1; i <= v; i++) {
				if (check[i] == 0)
					dfs(check, i, 1);
			}

			for (int i = 1; i <= v; i++) {
				for (int j : list[i]) {
					if (check[i] == check[j])
						b = false;
				}
			}
			
			if (b)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

		sc.close();
	}

	private static void dfs(int[] check, int x, int c) {
		check[x] = c;

		for (int y : list[x]) {
			if (check[y] == 0)
				dfs(check, y, 3 - c);
		}
	}
}
