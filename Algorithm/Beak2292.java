import java.util.Scanner;

public class Beak2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int val = 1;

		for (int i = 1;; i++) {
			val = 6 * (i - 1) + val;
			if (val >= target) {
				System.out.println(i);
				break;
			}

		}
		sc.close();
	}
}
