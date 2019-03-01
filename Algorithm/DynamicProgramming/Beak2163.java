package DynamicProgramming;

import java.util.Scanner;

public class Beak2163 {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		System.out.println(n * m - 1);
		sc.close();
	}
}
