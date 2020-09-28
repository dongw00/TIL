package fundamental;

import java.io.*;
import java.util.*;

public class Beak1644 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 2; i <= n; i++)
			if (prime(i))
				list.add(i);

		for (int i = 0; i < list.size(); i++) {
			int sum = 0;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j) != null)
					sum += list.get(j);
				if (sum == n) {
					cnt++;
					break;
				} else if (sum > n)
					break;
			}
		}

		System.out.println(cnt);
	}

	private static boolean prime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
