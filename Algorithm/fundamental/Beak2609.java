package fundamental;

import java.util.Scanner;

public class Beak2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int g = gcd(a, b);
		System.out.println(g);
		System.out.println(g * (a / g) * (b / g));

		sc.close();

	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
