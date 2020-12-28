package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1463_2 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        System.out.println(dp2(n));
    }

    private static int dp(int n) {
        if (n <= 3)
            return 1;
        else if (dp[n] > 0)
            return dp[n];

        dp[n] = dp(n - 1) + 1;

        if (n % 3 == 0)
            dp[n] = Math.min(dp[n], dp(n / 3) + 1);

        if (n % 2 == 0)
            dp[n] = Math.min(dp[n], dp(n / 2) + 1);

        return dp[n];
    }

    private static int dp2(int n) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            if (i * 2 < n + 1)
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);

            if (i * 3 < n + 1)
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }

        return dp[n];
    }
}
