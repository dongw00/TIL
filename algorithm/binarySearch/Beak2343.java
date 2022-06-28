package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2343 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(arr[i], left);
            right += arr[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calc(arr, mid) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static int calc(int[] arr, int mid) {
        int cnt = 1;
        int tmp = mid;

        for (int el : arr) {
            if (tmp - el < 0) {
                tmp = mid - el;
                cnt++;
            } else {
                tmp -= el;
            }
        }
        return cnt;
    }

}
