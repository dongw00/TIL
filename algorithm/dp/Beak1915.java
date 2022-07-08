package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1915 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dp[i][j] = tmp[j] - '0';

                if (dp[i][j] == 0) {
                    continue;
                }

                if (i == 0 || j == 0) {
                    max = Math.max(max, dp[i][j]);
                    continue;
                }

                dp[i][j] =
                    Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println((long) max * max);
    }
}
