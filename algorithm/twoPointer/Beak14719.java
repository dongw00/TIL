package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = w - 1;

        int ans = 0;
        int leftMax = arr[left], rightMax = arr[right];

        while (left < right) {
            if (arr[left] < arr[right]) {
                left++;
                if (leftMax < arr[left]) {
                    leftMax = arr[left];
                } else {
                    ans += leftMax - arr[left];
                }
            } else {
                right--;
                if (rightMax < arr[right]) {
                    rightMax = arr[right];
                } else {
                    ans += rightMax - arr[right];
                }
            }
        }

        System.out.println(ans);
    }
}
