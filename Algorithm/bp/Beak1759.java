package bp;

import java.io.*;
import java.util.*;

public class Beak1759 {
	static int l, c;
	static int[] result;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new char[c];
		result = new int[c];

		for (int i = 0; i < c; i++)
			arr[i] = st.nextToken().charAt(0);

		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
	}

	private static void dfs(int start, int depth, int consonant, int vowel) {
		for (int i = start; i < c; i++) {
			result[i] = 1;

			dfs(i + 1, depth + 1, consonant + (!check(arr[i]) ? 1 : 0), vowel + (!check(arr[i]) ? 0 : 1));

			result[i] = 0;
		}

		if (depth == l && consonant >= 2 && vowel >= 1)
			print();
	}

	private static void print() {
		for (int i = 0; i < c; i++)
			if (result[i] == 1)
				System.out.print(arr[i]);
		System.out.println();
	}

	private static boolean check(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			return true;
		else
			return false;
	}
}
