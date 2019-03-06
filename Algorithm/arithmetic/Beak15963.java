package arithmetic;

import java.util.Scanner;

public class Beak15963 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		double m = sc.nextDouble();

		if (n == m) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

		sc.close();
	}
}
