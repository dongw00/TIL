package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Beak2407 {

    static BigInteger[][] dp = new BigInteger[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp[1][0] = dp[1][1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
