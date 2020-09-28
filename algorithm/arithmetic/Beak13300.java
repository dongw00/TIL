package arithmetic;

import java.util.Scanner;

public class Beak13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum = 0;

		int[] man = new int[6];
		int[] woman = new int[6];

		for (int i = 0; i < n; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt() - 1;

			if (sex == 0) {
				woman[grade] += 1;
			} else {
				man[grade] += 1;
			}
		}

		for (int i = 0; i < 6; i++) {
			sum += Math.ceil(woman[i] / (double) k);
			sum += Math.ceil(man[i] / (double) k);
		}

		System.out.println(sum);

		sc.close();
	}
}
