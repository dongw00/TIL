import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2740 {
	private static int map_a[][];
	private static int map_b[][];
	private static int map_c[][];
	private static int N, M, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map_a = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map_a[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st2.nextToken());
		K = Integer.parseInt(st2.nextToken());
		
		map_b = new int[M][K];
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				map_b[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		
		map_c = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int k =0; k < M; k++) {
					map_c[i][j] += map_a[i][k] * map_b[k][j];
				}
				System.out.print(map_c[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
