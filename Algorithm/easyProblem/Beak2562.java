package easyProblem;

import java.io.*;

public class Beak2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = new int[9];

		int idx = 0;
		int max = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println((idx + 1));
	}
}
