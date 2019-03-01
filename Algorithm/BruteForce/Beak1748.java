package BruteForce;

import java.util.Scanner;

public class Beak1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int base = 10;
		int cnt = 1;
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			if (i == base) {
				base *= 10;
				cnt++;
			}
			sum += cnt;
		}

		System.out.println(sum);

		sc.close();
	}
}
