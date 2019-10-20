package Fasoo;

import java.io.*;
import java.util.*;

public class example_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int rect[][] = new int[3][2];
		int ans[] = new int[2];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				rect[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = solution(rect);

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + ", ");
		}
	}

	public static int[] solution(int[][] v) {
		int[] ans = new int[2];

		Map<Integer, Integer> mapX = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapY = new HashMap<Integer, Integer>();

		for (int i = 0; i < 3; i++) {
			mapX.put(v[i][0], mapX.containsKey(v[i][0]) == true ? mapX.get(v[i][0]) + 1 : 1);
		}

		for (int i = 0; i < 3; i++) {
			mapY.put(v[i][1], mapY.containsKey(v[i][1]) == true ? mapY.get(v[i][1]) + 1 : 1);
		}

		for (int i = 0; i < 3; i++) {
			if (mapX.get(v[i][0]) == 1)
				ans[0] = v[i][0];

			if (mapY.get(v[i][1]) == 1)
				ans[1] = v[i][1];
		}

		return ans;
	}
}
