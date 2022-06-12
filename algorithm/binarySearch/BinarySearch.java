package binarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 10, 40};
        Arrays.sort(arr);

        int idx = binarySearch(arr, 0, arr.length - 1, 10);
        int idx2 = binarySearch2(arr, 10);
        System.out.println(idx);
        System.out.println(idx2);
    }

    public static int binarySearch(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == num)
            return mid;

        if (arr[mid] > num) {
            return binarySearch(arr, left, mid - 1, num);
        }
        return binarySearch(arr, mid + 1, right, num);
    }

    public static int binarySearch2(int[] arr, int num) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
