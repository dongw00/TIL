package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = k - 1;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += arr[i];
        }
        long max = ans;

        for (right += 1; right < n; right++) {
            ans += arr[right];

            if (right - left + 1 > k) {
                ans -= arr[left++];
            }

            max = Math.max(max, ans);
        }

        System.out.println(max);
    }
}
