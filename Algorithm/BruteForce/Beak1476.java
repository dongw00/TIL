package BruteForce;

import java.util.Scanner;

public class Beak1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt() - 1;
		int S = sc.nextInt() - 1;
		int M = sc.nextInt() - 1;
		int y = 0;

		while (true) {
			if ((y % 15 == E) && (y % 28 == S) && (y % 19 == M)) {
				System.out.println(y + 1);
				break;
			}
			y++;
		}
		sc.close();
	}
}
