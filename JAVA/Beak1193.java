import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int up = 0;
		int down = 0;
		int n = 0;
		boolean b = false;

		for (int i = 1; i <= num; i++) {
			for (int j = 0; j < i; j++) {
				if (i % 2 == 0) {
					up = j + 1;
					down = i - j;
				} else {
					up = i - j;
					down = j + 1;
				}
				n++;

				if (num == n) {
					System.out.println(up + "/" + down);
					b = true;
					break;
				}
			}
			if (b) {
				break;
			}
		}

	}
}
