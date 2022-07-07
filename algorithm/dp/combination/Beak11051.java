package dp.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak11051 {

    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(comb(n, k));
    }

    public static int comb(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        return dp[n][k] = (comb(n - 1, k - 1) + comb(n - 1, k)) % 10007;
    }
}
