package graph.bfs;

import java.util.*;
import java.io.*;

class Pairs {
	int x, y;

	Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Beak4963 {
	static int[] dx = { 0, 0, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, 1, -1 };
	static int[][] check;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			int count = 0;

			if (w == 0 && h == 0)
				break;

			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			check = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && check[i][j] == 0)
						bfs(i, j, ++count, w, h);
				}
			}
			System.out.println(count);
		}
		br.close();
	}

	private static void bfs(int x, int y, int count, int w, int h) {
		Queue<Pairs> queue = new LinkedList<Pairs>();
		queue.add(new Pairs(x, y));
		check[x][y] = count;

		while (!queue.isEmpty()) {
			Pairs p = queue.remove();
			x = p.x;
			y = p.y;

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (arr[nx][ny] == 1 && check[nx][ny] == 0)
						bfs(nx, ny, count, w, h);
				}
			}
		}
	}
}
