package bp;

import java.io.*;
import java.util.*;

public class Beak1759 {
	static int n, m;
	static int[] result;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new char[n];
		result = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = st.nextToken().charAt(0);

		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
	}

	private static void dfs(int start, int depth, int con, int vo) {
		for (int i = start; i < n; i++) {
			result[i] = 1;

			dfs(i + 1, depth + 1, con + (!check(arr[i]) ? 1 : 0), vo + (!check(arr[i]) ? 0 : 1));

			result[i] = 0;
		}

		if (depth == m && con >= 2 && vo >= 1)
			print();
	}

	private static void print() {
		for (int i = 0; i < n; i++)
			if (result[i] == 1)
				System.out.print(arr[i]);
		System.out.println();
	}

	private static boolean check(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'u')
			return true;
		else
			return false;
	}
}
