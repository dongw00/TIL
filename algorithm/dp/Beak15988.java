package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak15988 {

    static long[] dp = new long[1000001];

    private static long dp(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }

        if (n < 3) {
            dp[n] = dp(n - 1) + dp(0);
        } else {
            dp[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
        }
        dp[n] %= 1000000009L;
        return dp[n];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }
}
