package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while (start < n && end < n) {
            int diff = arr[end] - arr[start];
            if (diff >= m) {
                start++;
                min = Math.min(min, diff);
            } else {
                end++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

}
