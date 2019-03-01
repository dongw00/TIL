package Arithmetic;

import java.util.Scanner;

public class Beak11966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		
		if (n == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		while (sum < n) {
			sum *= 2;
		}
		if (sum == n) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		sc.close();
	}
}
