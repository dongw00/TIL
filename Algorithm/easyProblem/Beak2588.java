package easyProblem;

import java.io.*;

public class Beak2588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		String str = br.readLine();

		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.println((str.charAt(i) - '0') * a);
		}

		System.out.println(Integer.parseInt(str) * a);
	}

}
