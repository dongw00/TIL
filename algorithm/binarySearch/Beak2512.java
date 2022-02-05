package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 1, right = arr[arr.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
