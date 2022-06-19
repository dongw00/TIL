package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak2018 {

    static final int INF = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[INF + 1];
        for (int i = 1; i <= INF; i++) {
            arr[i] = i;
        }

        int left = 0, right = 0, cnt = 0;

        int sum = 0;

        while (left < n) {
            if (sum >= n) {
                if (sum == n) {
                    cnt++;
                }
                sum -= arr[++left];
            } else {
                sum += arr[++right];
            }
        }
        System.out.println(cnt);
    }

}
