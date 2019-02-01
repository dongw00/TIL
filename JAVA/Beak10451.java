import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak10451 {
	private static int map[][];
	private static int count[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		map = new int[num][1001];
		count = new int[num];
		for (int i = 0; i < num; i++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= cnt; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			permutation(i, cnt);
			System.out.println(count[i]);
		}
	}

	private static void permutation(int n, int cnt) {
		for (int i = 1; i <= cnt; i++) {
			boolean bool = true;
			if (map[n][i] != -1) {
				int m = i;
				while (bool) {
					if (map[n][m] != -1) {
						int temp = m;
						m = map[n][m];
						map[n][temp] = -1;
					} else {
						count[n]++;
						bool = false;
					}
				}
			}
		}
	}
}
