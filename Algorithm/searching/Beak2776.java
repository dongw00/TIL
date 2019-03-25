package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2776 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] note1 = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++)
				note1[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(note1);

			int m = Integer.parseInt(br.readLine());
			int[] note2 = new int[m];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				note2[i] = Integer.parseInt(st.nextToken());
				System.out.println(Arrays.binarySearch(note1, note2[i]) > -1 ? "1" : "0");
			}
		}
	}
}
