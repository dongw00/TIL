import java.util.ArrayList;
import java.util.Scanner;

public class Eratos {
	public static void main(String[] args) {
		ArrayList<Boolean> primeList;

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n <= 1)
			return;

		primeList = new ArrayList<Boolean>(n + 1);
		/* 0, 1번째를 소수 아님으로 처리 */
		primeList.add(false);
		primeList.add(false);

		for (int i = 2; i <= n; i++)
			primeList.add(i, true);

		for (int i = 2; (i * i) <= n; i++) {
			if (primeList.get(i))
				for (int j = i * i; j <= n; j += i)
					primeList.set(j, false);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i <= n; i++) {
			if (primeList.get(i) == true) {
				sb.append(i);
				sb.append(",");
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		System.out.println(sb.toString());
	}
}
