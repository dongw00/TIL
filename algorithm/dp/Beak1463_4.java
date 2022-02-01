package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1463_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        } else if (n <= 3) {
            System.out.println(1);
            System.exit(0);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = dp[3] = 1;

        System.out.println(bottomUp(dp, n));
        System.out.println(topDown(dp, n));
    }

    public static int bottomUp(int[] dp, int n) {
        if (n == 1) {
            return 0;
        } else if (n <= 3) {
            return 1;
        }

        for (int i = 3; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            if (i * 2 <= n) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= n) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[n];
    }

    public static int topDown(int[] dp, int n) {
        if (n == 1) {
            return 0;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = Math.min(dp[n], topDown(dp, n - 1) + 1);

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], topDown(dp, n / 3) + 1);
        }

        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], topDown(dp, n / 2) + 1);
        }

        return dp[n];
    }
}
