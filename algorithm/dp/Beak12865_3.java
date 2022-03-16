package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak12865_3 {

    static Pair[] arr;
    static int[][] dp;

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new Pair[n];
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(w, v);
        }

        System.out.println(dp(n - 1, k));
    }

    public static int dp(int idx, int k) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][k] > 0) {
            return dp[idx][k];
        }

        if (arr[idx].weight > k) {
            dp[idx][k] = dp(idx - 1, k);
        } else {
            dp[idx][k] = Math.max(dp(idx - 1, k), dp(idx - 1, k - arr[idx].weight) + arr[idx].value);
        }
        return dp[idx][k];
    }

    static class Pair {
        int weight, value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
