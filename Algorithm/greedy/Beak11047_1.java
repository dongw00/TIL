package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak11047_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[m];

		for (int i = 0; i < m; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i = m - 1; i >= 0; i--) {
			if (n >= arr[i]) {
				count += n / arr[i];
				n %= arr[i];
			}
		}

		System.out.println(count);
	}
}
