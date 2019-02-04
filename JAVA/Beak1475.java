import java.util.Scanner;

public class Beak1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int a[] = new int[10];
		int max = 0;

		num = num.replace('9', '6');

		for (int i = 0; i < num.length(); i++)
			a[num.charAt(i) - 48]++;
		a[6] = a[6] / 2 + a[6] % 2;

		for (int i = 0; i < 9; i++) {
			if (max < a[i])
				max = a[i];
		}
		System.out.println(max);

		sc.close();
	}
}
