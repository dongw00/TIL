package other_algorithm;

import java.util.*;

public class Beak7737 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt() - 2;
		int m = sc.nextInt();

		double sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += (combination(2 * i, i) - combination(2 * i, i + 1));
		}

		System.out.println((int) sum % m);

		sc.close();
	}

	private static double combination(int n, int r) {
		int rfact = 1, nfact = 1, nrfact = 1, temp1 = n - r, temp2 = r;
		if (r > n - r) {
			temp1 = r;
			temp2 = n - r;
		}

		for (int i = 1; i <= n; i++) {
			if (i <= temp2) {
				rfact *= i;
				nrfact *= i;
			} else if (i <= temp1)
				nrfact *= i;
			nfact *= i;
		}
		return nfact / (double) (rfact * nrfact);
	}
}
