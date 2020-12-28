package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2294_2 {
    static int N, K;
    static int[][] dp;
    static int[] arr;

    static int IMPOSSIBLE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int res = dp(0, K);
        if (res == IMPOSSIBLE)
            System.out.println(-1);
        else
            System.out.println(res);
    }

    private static int dp(int n, int k) {
        if (n == N)
            return k == 0 ? 0 : IMPOSSIBLE;

        if (dp[n][k] > 0)
            return dp[n][k];

        int res = dp(n + 1, k);
        if (k >= arr[n])
            res = Math.min(res, dp(n, k - arr[n]) + 1);
        dp[n][k] = res;
        return res;
    }
}
