package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        System.out.println(helper(dp, n));
    }

    private static long helper(long[] dp, int n) {
        if (n <= 2)
            return 1;

        if (dp[n] > 0)
            return dp[n];

        dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
        return dp[n];
    }
}
