package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak12865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pair[] arr = new Pair[n];
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(w, v);
        }

        System.out.println(knapsack(arr, dp, n - 1, k));
    }

    public static int knapsack(Pair[] arr, int[][] dp, int idx, int k) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][k] > 0) {
            return dp[idx][k];
        }

        if (arr[idx].weight > k) {
            dp[idx][k] = knapsack(arr, dp, idx - 1, k);
        } else {
            dp[idx][k] = Math.max(knapsack(arr, dp, idx - 1, k), knapsack(arr, dp, idx - 1, k - arr[idx].weight) + arr[idx].value);
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
