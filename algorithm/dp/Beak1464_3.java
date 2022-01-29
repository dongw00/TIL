package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1464_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        System.out.println(helper2(dp, n));

    }

    private static int helper(int[] dp, int n) {
        if (n == 1) {
            return 0;
        } else if (n <= 3) {
            return 1;
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 3; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            if (i * 2 <= n) {
                dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            }

            if (i * 3 <= n) {
                dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
        }
        return dp[n];
    }

    private static int helper2(int[] dp, int n) {
        if (n == 1) {
            return 0;
        } else if (n <= 3) {
            return 1;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = helper2(dp, n - 1) + 1;

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], helper2(dp, n / 3) + 1);
        }

        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], helper2(dp, n / 2) + 1);
        }

        return dp[n];
    }
}
