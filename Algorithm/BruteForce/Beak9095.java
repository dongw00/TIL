package BruteForce;

import java.util.Scanner;

public class Beak9095 {
	static int MAX = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int res = 0;
			for (int l1 = 1; l1 <= MAX; l1++) {
				if (l1 == n)
					res += 1;
				for (int l2 = 1; l2 <= MAX; l2++) {
					if (l1 + l2 == n)
						res += 1;
					for (int l3 = 1; l3 <= MAX; l3++) {
						if (l1 + l2 + l3 == n)
							res += 1;
						for (int l4 = 1; l4 <= MAX; l4++) {
							if (l1 + l2 + l3 + l4 == n)
								res += 1;
							for (int l5 = 1; l5 <= MAX; l5++) {
								if (l1 + l2 + l3 + l4 + l5 == n)
									res += 1;
								for (int l6 = 1; l6 <= MAX; l6++) {
									if (l1 + l2 + l3 + l4 + l5 + l6 == n)
										res += 1;
									for (int l7 = 1; l7 <= MAX; l7++) {
										if (l1 + l2 + l3 + l4 + l5 + l6 + l7 == n)
											res += 1;
										for (int l8 = 1; l8 <= MAX; l8++) {
											if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 == n)
												res += 1;
											for (int l9 = 1; l9 <= MAX; l9++) {
												if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 == n)
													res += 1;
												for (int l10 = 1; l10 <= MAX; l10++) {
													if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 == n)
														res += 1;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(res);
		}

		sc.close();
	}
}
