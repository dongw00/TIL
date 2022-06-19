package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1940 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = n - 1;
        int cnt = 0;

        while (left < right) {
            int tmp = arr[left] + arr[right];

            if (tmp == m) {
                cnt++;
                left++;
                right--;
            } else if (tmp > m) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(cnt);
    }
}