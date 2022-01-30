package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak10844 {

    static final int MOD = 1000000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        long ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += dp(dp, n, i);
        }

        System.out.println(ans % MOD);
    }

    public static long dp(long[][] dp, int digit, int val) {
        if (digit == 1) {
            return 1;
        }

        if (dp[digit][val] > 0) {
            return dp[digit][val];
        }

        if (val == 0) {
            dp[digit][val] = dp(dp, digit - 1, 1) % MOD;
        } else if (val == 9) {
            dp[digit][val] = dp(dp, digit - 1, 8) % MOD;
        } else {
            dp[digit][val] = (dp(dp, digit - 1, val - 1) + dp(dp, digit - 1, val + 1)) % MOD;
        }
        return dp[digit][val];
    }
}
