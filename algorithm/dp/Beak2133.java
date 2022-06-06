package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak2133 {

    static int[] dp = new int[31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n == 0)
            return 1;
        else if (n <= 1)
            return 0;
        else if (n == 2)
            return 3;
        

        if (dp[n] > 0) {
            return dp[n];
        }

        int res = dp(n - 2) * 3;
        for (int i = 4; i <= n; i += 2) {
            res += dp(n - i) * 2;
        }
        return dp[n] = res;
    }
}
