package Fundamental;

import java.util.Scanner;

public class Beak11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.print("Case #" + (i + 1) + ": ");
			System.out.println(A + " + " + B + " = " + (A + B));
		}
		sc.close();
	}

}
