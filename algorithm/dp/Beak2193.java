package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        System.out.println(topDown(dp, n));
        System.out.println(bottomUp(dp, n));
    }

    public static long topDown(long[] dp, int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = topDown(dp, n - 1) + topDown(dp, n - 2);
        return dp[n];
    }

    public static long bottomUp(long[] dp, int n) {
        if (n <= 2) {
            return 1;
        }

        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

}
