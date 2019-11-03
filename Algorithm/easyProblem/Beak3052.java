package easyProblem;

import java.io.*;

public class Beak3052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = new int[42];
		int cnt = 0;

		for (int i = 0; i < 10; i++) {
			int val = Integer.parseInt(br.readLine()) % 42;
			arr[val]++;
		}

		for (int i : arr) {
			if (i != 0)
				cnt++;
		}

		System.out.println(cnt);
	}

}
