package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak2302 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 1;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            int idx = Integer.parseInt(br.readLine());
            ans *= dp[idx - cur - 1];
            cur = idx;
        }

        ans *= dp[n - cur];

        System.out.println(ans);
    }
}
