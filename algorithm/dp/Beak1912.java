package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] < dp[i - 1] + arr[i]) {
                dp[i] = dp[i - 1] + arr[i];
            }
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}
