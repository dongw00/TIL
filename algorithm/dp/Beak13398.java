package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak13398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = arr[0];
        r[n - 1] = arr[n - 1];

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1] + arr[i], arr[i]);
            max = Math.max(l[i], max);
        }

        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1] + arr[i], arr[i]);
        }

        int[] dp = new int[n];
        for (int i = 1; i < n - 1; i++) {
            dp[i] = l[i - 1] + r[i + 1];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
