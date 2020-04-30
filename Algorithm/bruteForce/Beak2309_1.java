package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak2309_1 {

    private static void findTwoDrwarf(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                arr[left] = 0;
                arr[right] = 0;
                return;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);

        findTwoDrwarf(height, sum - 100);

        for (int i = 0; i < 9; i++) {
            if (height[i] != 0) {
                System.out.println(height[i]);
            }
        }
    }
}
