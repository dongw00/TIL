package startupCodingFestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class scf_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n];

        String[] str = br.readLine().split("");

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(str[i]);
        }

        for (int i = 2; i < n; i++) {
            if (dp[i] != 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        System.out.println(dp[n - 1]);
    }
}
