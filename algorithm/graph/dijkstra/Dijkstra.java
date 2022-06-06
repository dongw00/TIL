package graph.dijkstra;

import java.util.Arrays;

public class Dijkstra {

    static int[][] arr;
    static boolean[] check;
    static int[] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 6;

        arr = new int[][]{
                {0, 2, 5, 1, INF, INF},
                {2, 0, 3, 2, INF, INF},
                {5, 3, 0, 3, 1, 5},
                {1, 2, 3, 0, 1, INF},
                {INF, INF, 1, 1, 0, 2},
                {INF, INF, 5, INF, 2, 0}
        };

        dp = new int[n];
        check = new boolean[n];

        // 다익스트라 알고리즘 시작 (시작 노드 0)
        for (int i = 0; i < n; i++) {
            dp[i] = arr[0][i];
        }

        check[0] = true;
        for (int i = 0; i < n - 2; i++) {
            int current = getSmallIdx();
            check[current] = true;

            for (int j = 0; j < n; j++) {
                if (!check[j] && arr[current][j] != INF) {
                    if (dp[current] + arr[current][j] < dp[j]) {
                        dp[j] = dp[current] + arr[current][j];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }

    private static int getSmallIdx() {
        int n = dp.length;
        int min = INF;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] < min && !check[i]) {
                min = dp[i];
                idx = i;
            }
        }
        return idx;
    }
}
