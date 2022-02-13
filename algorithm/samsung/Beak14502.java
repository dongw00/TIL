package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak14502 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n, m, max;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int[][] virus_arr = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus_arr[i][j] = arr[i][j];

                if (arr[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (virus_arr[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                        virus_arr[nx][ny] = 2;
                    }
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_arr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);
    }

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
        }
    }

}
