package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak7562_2 {

    private static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    private static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] dist = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
                continue;
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(x1, y1));
            dist[x1][x2] = 0;

            Outter: while (!queue.isEmpty()) {
                Pair p = queue.remove();

                for (int i = 0; i < dx.length; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (nx == x2 && ny == y2) {
                            System.out.println(dist[p.x][p.y] + 1);
                            break Outter;
                        }
                        if (dist[nx][ny] == 0) {
                            queue.add(new Pair(nx, ny));
                            dist[nx][ny] = dist[p.x][p.y] + 1;
                        }
                    }
                }
            }
        }
    }
}