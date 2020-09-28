package greedy;

import java.util.*;
import java.io.*;

public class Beak4796 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int idx = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0)
				break;

			int temp = (V % P > L) ? L : V % P;
			int result = (V / P) * L + temp;
			System.out.println("Case " + idx++ + ": " + result);
		}
	}
}
