package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14728 {

    static int[] K, S;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        K = new int[n];
        S = new int[n];

        dp = new int[n][t + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        dp(n - 1, t);
        System.out.println(dp[n - 1][t]);
    }

    private static int dp(int idx, int t) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][t] > 0) {
            return dp[idx][t];
        }

        if (t - K[idx] < 0) {
            dp[idx][t] = dp(idx - 1, t);
        } else {
            dp[idx][t] = Math.max(dp(idx - 1, t), dp(idx - 1, t - K[idx]) + S[idx]);
        }
        return dp[idx][t];
    }

}
