package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak12865_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pair[] arr = new Pair[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(w, v);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i].weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].weight] + arr[i].value);
                }
            }
        }

        System.out.println(dp[n][k]);
    }

    static class Pair {
        int weight, value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
