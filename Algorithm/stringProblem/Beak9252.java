package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak9252 {
	static int lcs[][] = new int[1001][1001];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String str1 = br.readLine();
		String str2 = br.readLine();

		System.out.println(getLCS(str1, str2));

		getString(str1, str2);
		System.out.println(sb.reverse());
	}

	private static int getLCS(String str1, String str2) {
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[str1.length()][str2.length()];
	}

	private static void getString(String str1, String str2) {
		int x = str1.length();
		int y = str2.length();

		while (!(x == 0 || y == 0)) {
			if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
				sb.append(str1.charAt(x - 1));
				x--;
				y--;
			} else if (lcs[x][y] == lcs[x - 1][y]) {
				x--;
			} else if (lcs[x][y] == lcs[x][y - 1]) {
				y--;
			}
		}
	}
}
