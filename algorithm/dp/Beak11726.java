package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak11726 {

    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        return dp[n] = (dp(n - 1) + dp(n - 2)) % 10007;
    }
}
