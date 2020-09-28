package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14503 {
    private static int n, m;
    private static int cnt = 0;
    private static int[][] arr;
    private static int r, c, d;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static void dfs(int x, int y, int d) {
        if (arr[x][y] == 1)
            return;

        if (arr[x][y] == 0) {
            arr[x][y] = 2;
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nd = (d + 3 - i) % 4;
            int nx = dx[nd] + x;
            int ny = dy[nd] + y;

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] == 0) {
                    dfs(nx, ny, nd);
                }
            }
        }

        int nd = (d + 2) % 4;
        int nx = x + dx[nd];
        int ny = y + dy[nd];

        if (arr[nx][ny] == 1) {
            System.out.println(cnt);
            System.exit(0);
        }

        dfs(nx, ny, d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(cnt);
    }
}