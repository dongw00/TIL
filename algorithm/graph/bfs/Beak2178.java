package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2178 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static class Pair {

        int x, y, cnt;

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String in = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = in.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1));
        visited[0][0] = true;

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            if (p.x == n - 1 && p.y == m - 1) {
                min = Math.min(p.cnt, min);
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Pair(nx, ny, p.cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(min);
    }
}
