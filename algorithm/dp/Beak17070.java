package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak17070 {

    static int n, ans;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        dfs(1, 2, 0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int dir) {
        if (x == n && y == n) {
            ans++;
            return;
        }

        switch (dir) {
            case 0:
                if (y + 1 <= n && arr[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
                break;
            case 1:
                if (x + 1 <= n && arr[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
            case 2:
                if (y + 1 <= n && arr[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }

                if (x + 1 <= n && arr[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
        }

        if (x + 1 <= n && y + 1 <= n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
