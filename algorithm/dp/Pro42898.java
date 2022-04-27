package dp;

public class Pro42898 {

    final int MOD = 1000000007;

    public static void main(String[] args) {
        Pro42898 p = new Pro42898();

        System.out.println(p.solution(4, 3, new int[][]{{2, 2}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];

        dp[1][1] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (j - 1 > 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
