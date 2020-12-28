package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak1463 {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        System.out.println(dp(n));

    }

    private static int dp(int n) {
        if (n == 1)
            return 0;
        if (arr[n] > 0)
            return arr[n];

        arr[n] = dp(n - 1) + 1;

        if (n % 2 == 0)
            arr[n] = Math.min(arr[n], dp(n / 2) + 1);

        if (n % 3 == 0)
            arr[n] = Math.min(arr[n], dp(n / 3) + 1);

        return arr[n];
    }
}
