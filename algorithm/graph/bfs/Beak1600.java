package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1600 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        boolean[][][] visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0, k));
        visited[0][0][k] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if (p.x == h - 1 && p.y == w - 1) {
                System.out.println(p.cnt);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (!visited[nx][ny][p.k] && arr[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny, p.cnt + 1, p.k));
                        visited[nx][ny][p.k] = true;
                    }
                }
            }

            if (p.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = p.x + hdx[i];
                    int ny = p.y + hdy[i];

                    if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                        if (!visited[nx][ny][p.k - 1] && arr[nx][ny] == 0) {
                            queue.add(new Pair(nx, ny, p.cnt + 1, p.k - 1));
                            visited[nx][ny][p.k - 1] = true;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Pair {

        int x, y, cnt, k;

        Pair(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }

}
