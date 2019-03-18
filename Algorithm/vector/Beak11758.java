package vector;

import java.util.Scanner;

public class Beak11758 {
	private static int cross(int x1, int y1, int x2, int y2) {
		return x1 * y2 - x2 * y1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		int c = cross(x2 - x1, y2 - y1, x3 - x1, y3 - y1);

		if (c > 0)
			System.out.println(1);
		else if (c < 0)
			System.out.println(-1);
		else
			System.out.println(0);

		sc.close();
	}
}
