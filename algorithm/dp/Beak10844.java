package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak10844 {
    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 > 0)
                    dp[i][j] += dp[i - 1][j - 1];
                if (j + 1 <= 9)
                    dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= mod;
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++)
            ans += dp[n][i];
        System.out.println(ans % mod);
    }
}
