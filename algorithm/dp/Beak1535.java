package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1535 {

    static int[] L, J;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n][101];

        L = new int[n];
        J = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(n - 1, 100));
    }

    public static int dp(int idx, int limit) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][limit] > 0) {
            return dp[idx][limit];
        }

        if (limit - L[idx] <= 0) {
            dp[idx][limit] = dp(idx - 1, limit);
        } else {
            dp[idx][limit] = Math.max(dp(idx - 1, limit), dp(idx - 1, limit - L[idx]) + J[idx]);
        }

        return dp[idx][limit];
    }
}
