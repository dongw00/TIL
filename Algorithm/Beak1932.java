import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1932 {
	private static int map[][];
	private static int n, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = 0, b = 0;
			while (st.hasMoreTokens()) {
				map[a][i - 1 - b] = Integer.parseInt(st.nextToken());
				a++; b++;
			}
		}
		System.out.println(dp());
	}
	private static int dp() {
		//�꽭濡�
		for (int i=1; i<n; i++)
			map[i][0] += map[i-1][0];
		//媛�濡�
		for (int i=1; i<n; i++) 
			map[0][i] += map[0][i-1];
		//�뜑�븯湲�
		for (int i=1; i<n; i++)
			for (int j=1; j<n-i; j++)
				map[i][j] += Math.max(map[i-1][j], map[i][j-1]);
		
		max = map[n-1][0];
		//理쒕�媛� 諛섑솚
		for (int i=0; i<n-1; i++) {
			System.out.println(max);
			max = Math.max(max, map[n-i-2][i+1]);
		}
			
		return max;
	}
}