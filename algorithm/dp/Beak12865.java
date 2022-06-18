package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak12865 {

    static int[] W, V;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(N - 1, K));
    }

    private static int dp(int idx, int k) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][k] > 0) {
            return dp[idx][k];
        }

        if (W[idx] > k) {
            dp[idx][k] = dp(idx - 1, k);   // 담지 않는 경우
        } else {
            dp[idx][k] = Math.max(dp(idx - 1, k),
                dp(idx - 1, k - W[idx]) + V[idx]);  // 담은경우
        }
        return dp[idx][k];
    }
}
