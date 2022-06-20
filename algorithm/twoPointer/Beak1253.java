package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1253 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = 0;

        for (int k = 0; k < n; k++) {
            int left = 0, right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == arr[k]) {
                    if (left != k && right != k) {
                        ans++;
                        break;
                    } else if (left == k) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (sum > arr[k]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(ans);
    }

}
