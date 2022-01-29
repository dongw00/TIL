package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak15988_2 {

    static final long NUMBER = 1000000009L;
    static long[] dp = new long[1000001];

    // Bottom-up 방식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] > 0) {
                System.out.println(dp[n]);
                continue;
            }

            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % NUMBER;
            }
            System.out.println(dp[n]);
        }
    }

}
