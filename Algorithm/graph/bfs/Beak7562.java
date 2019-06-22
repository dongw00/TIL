package graph.bfs;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class Beak7562 {
	static int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int l = Integer.parseInt(br.readLine());

			int dist[][] = new int[l][l];

			Queue<Point> que = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());

			if (x == targetX && y == targetY) {
				System.out.println(0);
				continue;
			}

			que.add(new Point(x, y));

			Outter: while (!que.isEmpty()) {
				Point p = que.remove();

				for (int i = 0; i < dx.length; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (0 <= nx && nx < l && 0 <= ny && ny < l) {
						if (dist[nx][ny] == 0) {
							if (nx == targetX && ny == targetY) {
								System.out.println(dist[p.x][p.y] + 1);
								break Outter;
							}

							que.add(new Point(nx, ny));
							dist[nx][ny] = dist[p.x][p.y] + 1;
						}
					}
				}
			}
		}
	}
}
