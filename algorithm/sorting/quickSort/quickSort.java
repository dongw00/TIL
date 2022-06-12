package sorting.quickSort;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 2, 1, 0, 9, 6};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = (left + right) / 2;

        while (left <= right) {
            while (arr[left] < arr[pivot]) {
                left++;
            }
            while (arr[right] > arr[pivot]) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int idx = partition(arr, left, right);
        sort(arr, left, idx - 1);
        sort(arr, idx, right);
    }
}
