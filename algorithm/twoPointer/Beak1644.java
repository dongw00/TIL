package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (arr[i])
                continue;
            for (int j = i * 2; j <= n; j += i) {
                arr[j] = true;
            }
        }

        int start = 1, end = 1;
        int ans = 0, sum = 0;

        while (true) {
            if (end <= n && arr[end]) {
                end++;
                continue;
            }
            if (start <= n && arr[start]) {
                start++;
                continue;
            }

            if (sum >= n) {
                sum -= start++;
            } else if (end == n + 1)
                break;
            else
                sum += end++;

            if (sum == n)
                ans++;
        }

        System.out.println(ans);
    }
}
