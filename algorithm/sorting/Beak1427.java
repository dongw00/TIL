package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Beak1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split("");

		Arrays.sort(str, Collections.reverseOrder());

		for (int i = 0; i < str.length; i++)
			System.out.print(str[i].charAt(0) - '0');
		System.out.println();
	}
}
