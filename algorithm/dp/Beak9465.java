package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n];
            int[][] dp = new int[n][3];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                dp[i + 1][0] = Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2]));
                dp[i + 1][1] = Math.max(dp[i][0], dp[i][2]) + arr[0][i];
                dp[i + 1][2] = Math.max(dp[i][0], dp[i][1]) + arr[1][i];
            }

            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
}
