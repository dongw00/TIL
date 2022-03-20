package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak1309_2 {

    static final int MOD = 9901;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[100001][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 0; i < 3; i++) {
            dp(n, i);
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % MOD);
    }

    public static int dp(int n, int p) {
        if (dp[n][p] > 0) {
            return dp[n][p];
        }

        if (p == 0) {
            return dp[n][0] = (dp(n - 1, 0) + dp(n - 1, 1) + dp(n - 1, 2)) % MOD;
        } else if (p == 1) {
            return dp[n][1] = (dp(n - 1, 0) + dp(n - 1, 2)) % MOD;
        } else {
            return dp[n][2] = (dp(n - 1, 0) + dp(n - 1, 1)) % MOD;
        }
    }
}
