package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak10816_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int el = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, el) - lowerBound(arr, el));

            if (i != m - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    public static int upperBound(int[] arr, int key) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int lowerBound(int[] arr, int key) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
