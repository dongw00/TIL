import java.util.Scanner;

public class Beak2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(el(k, n));
		}
		sc.close();
	}

	private static int el(int k, int n) {
		if (n == 0)
			return 0;
		else if (k == 0)
			return n;
		else {
			return el(k, n - 1) + el(k - 1, n);
		}
	}
}
