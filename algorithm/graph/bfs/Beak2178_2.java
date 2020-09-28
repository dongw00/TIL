package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2178_2 {
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 };

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        dist[0][0] = cnt;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 1 && dist[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                    }
                }
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}