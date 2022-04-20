package binarySearch;

import java.util.Arrays;

public class Pro43238 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0, right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int el : times) {
                sum += mid / el;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
