package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(topDown(dp, arr, n));
        System.out.println(bottomUp(dp, arr, n));
    }

    public static int topDown(int[] dp, int[] arr, int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return arr[1];
        } else if (n == 2) {
            return arr[1] + arr[2];
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = Math.max(topDown(dp, arr, n - 2), topDown(dp, arr, n - 3) + arr[n - 1]) + arr[n];
        return dp[n];
    }

    public static int bottomUp(int[] dp, int[] arr, int n) {
        dp[0] = 0;
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        return dp[n];
    }

}
