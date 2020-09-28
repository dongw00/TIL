import java.util.Scanner;

public class Beak2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String str = sc.next();

		for (int i = 0; i < 8; i++)
			str = str.replace(croatia[i], "a");
		System.out.println(str.length());
		sc.close();
	}
}
