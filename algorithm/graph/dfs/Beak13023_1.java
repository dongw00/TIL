package graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Beak13023_1 {
	static boolean ans;
	static ArrayList<Integer> list[];
	static boolean[] chk;

	private static void dfs(int now, int cnt) {
		if (cnt == 5) {
			ans = true;
			return;
		}

		chk[now] = true;
		for (int next : list[now]) {
			if (!chk[next])
				dfs(next, cnt + 1);
			if (ans)
				return;
		}
		chk[now] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		list = new ArrayList[n];
		chk = new boolean[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			dfs(i, 1);
			if (ans)
				break;
		}

		if (ans)
			System.out.println(1);
		else
			System.out.println(0);

		sc.close();
	}
}
