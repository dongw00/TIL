import java.util.*;
import java.io.*;

public class Synap {
	// DFS 탐색
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	// 가로 x 세로
	static final int WIDTH = 1981;
	static final int HEIGHT = 1081;

	static int arr[][] = new int[HEIGHT][WIDTH];
	static boolean visit[][] = new boolean[HEIGHT][WIDTH];

	static int ans = 0;

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < dx.length; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= nx && nx < HEIGHT && 0 <= ny && ny < WIDTH) {
				if (arr[nx][ny] == 1 && !visit[nx][ny]) {
					ans++;
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문제 조건에 입력 라인의 수가 주어지지 않아 예제 입력의 라인 수를 읽게 구성하였습니다.
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					arr[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					ans++;
					dfs(i, j);
				}
			}
		}

		System.out.println(ans);
	}
}
