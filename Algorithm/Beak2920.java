import java.util.Scanner;

public class Beak2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n[] = new int[8];
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			n[i] = sc.nextInt();
		}
		for (int i = 0; i < 7; i++) {
			if (n[i] - n[i + 1] == 1)
				sum = 1;
			else if (n[i] - n[i + 1] == -1)
				sum = 0;
			else {
				sum = 2;
				break;
			}

		}
		switch (sum) {
		case 0:
			System.out.println("ascending");
			break;
		case 1:
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
		}
		sc.close();
	}
}
