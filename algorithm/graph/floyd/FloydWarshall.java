package graph.floyd;

import java.util.Arrays;

public class FloydWarshall {

    static final int INF = 1000000;

    static int[][] arr = {
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };

    public static void floyd() {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, dp[i], 0, n);
        }

        // k = 거쳐가는 노드
        for (int k = 0; k < n; k++) {
            // i = 출발노드
            for (int i = 0; i < n; i++) {
                // j = 도착 노드
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }

    public static void main(String[] args) {
        floyd();
    }
}
