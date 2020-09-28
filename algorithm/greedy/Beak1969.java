package greedy;

import java.io.*;
import java.util.*;

public class Beak1969 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}

		int dna = 0;

		for (int i = 0; i < m; i++) {
			int a = 0, t = 0, g = 0, c = 0, max = 0;
			for (int j = 0; j < n; j++) {
				switch (str[j].charAt(i)) {
				case 'A':
					a++;
					break;
				case 'T':
					t++;
					break;
				case 'G':
					g++;
					break;
				case 'C':
					c++;
					break;
				}
			}

			max = Math.max(a > t ? a : t, g > c ? g : c);
			dna += (n - max);

			if (max == a)
				System.out.print('A');
			else if (max == c)
				System.out.print('C');
			else if (max == g)
				System.out.print('G');
			else
				System.out.print('T');
		}
		System.out.println("\n" + dna);
	}
}
