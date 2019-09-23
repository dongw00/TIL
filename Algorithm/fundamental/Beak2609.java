package fundamental;

import java.util.Scanner;

public class Beak2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a < b) {
			int tmp = b;
			b = a;
			a = tmp;
		}

		int g = gcd(a, b);
		System.out.println(g);
		System.out.println(a * b / result);

		sc.close();

	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
