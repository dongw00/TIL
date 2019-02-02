import java.util.Scanner;

public class Beak1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		Boolean b = true;
		int count = 0;

		for (int i = 0; i < num; i++) {
			int pNum = sc.nextInt();

			if (pNum <= 1)
				b = false;
			else {
				for (int j = 2; j <= pNum / 2; j++)
					if (pNum % j == 0)
						b = false;
			}
			if (b)
				count++;
			b = true;
		}

		System.out.println(count);
		sc.close();
	}
}
