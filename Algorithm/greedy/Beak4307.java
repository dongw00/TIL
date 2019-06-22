package greedy;

import java.io.*;
import java.util.*;

public class Beak4307 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int MIN = Integer.MIN_VALUE;
			int MAX = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(br.readLine());

				int tmpMIN = Math.min(temp, l - temp);
				int tmpMAX = Math.max(temp, l - temp);

				MIN = Math.max(MIN, tmpMIN);
				MAX = Math.max(MAX, tmpMAX);
			}
			System.out.println(MIN + " " + MAX);
		}
	}
}
