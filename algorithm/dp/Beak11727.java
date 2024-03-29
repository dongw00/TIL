package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak11727 {

    static int[] dp = new int[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        return dp[n] = (dp(n - 1) + dp(n - 2) * 2) % 10007;
    }
}
