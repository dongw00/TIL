import java.util.Scanner;

public class Beak2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int cnt = sc.nextInt();
			String str = sc.nextLine();

			String result = "";
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < cnt; k++)
					result += str.charAt(j);
			}
			result = result.replaceAll(" ", "");
			System.out.println(result);
		}
		sc.close();
	}
}
