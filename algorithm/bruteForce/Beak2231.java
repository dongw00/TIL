package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = n; i > 0; i--) {
			int sum = 0;
			String[] str = String.valueOf(i).split("");

			for (int j = 0; j < str.length; j++)
				sum += Integer.parseInt(str[j]);

			if (i + sum == n)
				result = i;
		}

		if (result == 0)
			System.out.println(0);
		else
			System.out.println(result);
	}
}
