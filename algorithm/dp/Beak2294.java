package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 1; i <= k; i++)
            dp[i] = 100000;

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int num : arr) {
            for (int i = num; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }

        if (dp[k] != 100000)
            System.out.println(dp[k]);
        else
            System.out.println(-1);
    }
}
