package dp.combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak1010 {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(comb(m, n) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int comb(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        return dp[n][k] = comb(n - 1, k - 1) + comb(n - 1, k);
    }

}
