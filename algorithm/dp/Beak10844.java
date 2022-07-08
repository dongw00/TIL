package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak10844 {

    static final int MOD = 1000000000;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0; i < 10; i++) {
            dp(n, i);
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }

    public static int dp(int n, int m) {
        if (n == 0) {
            return 0;
        }
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (m == 0) {
            return dp[n][m] = dp(n - 1, 1);
        } else if (m == 9) {
            return dp[n][m] = dp(n - 1, 8);
        } else {
            return dp[n][m] = (dp(n - 1, m - 1) + dp(n - 1, m + 1)) % MOD;
        }
    }
}
