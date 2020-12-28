package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak9465_2 {

    static int[][] dp;
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            arr = new int[2][n];
            dp = new int[n + 1][3];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = -1;
                }
            }
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(sticker(0, 0));
        }
    }

    private static int sticker(int c, int status) {
        if (c == n)
            return 0;
        else if (dp[c][status] != -1)
            return dp[c][status];

        int res = sticker(c + 1, 0);
        if (status != 2)
            res = Math.max(res, sticker(c + 1, 2) + arr[1][c]);
        if (status != 1)
            res = Math.max(res, sticker(c + 1, 1) + arr[0][c]);
        dp[c][status] = res;
        return res;
    }
}
