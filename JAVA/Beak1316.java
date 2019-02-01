import java.util.Scanner;

public class Beak1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int result = num;

		for (int i = 0; i < num; i++) {
			String str = sc.next();
			boolean[] check = new boolean[26];

			for (int j = 1; j < str.length(); j++)
				if (str.charAt(j - 1) != str.charAt(j)) {
					if (check[str.charAt(j) - 97]) {
						result--;
						break;
					}
					check[str.charAt(j - 1) - 97] = true;
				}
		}
		System.out.println(result);
		sc.close();
	}
}
