package dp.combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Beak2775 {

    static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write(comb(k, n) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int comb(int k, int n) {
        if (n == 0) {
            return 0;
        } else if (k == 0) {
            return n;
        }

        if (dp[k][n] > 0) {
            return dp[k][n];
        }

        return dp[k][n] = comb(k - 1, n) + comb(k, n - 1);
    }

}
