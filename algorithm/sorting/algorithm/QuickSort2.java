package sorting.algorithm;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int idx = partition(arr, left, right);
        quickSort(arr, left, idx - 1);
        quickSort(arr, idx + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;

        left++;
        while (left <= right) {
            while (left < arr.length && arr[left] < arr[pivot]) {
                left++;
            }
            while (right >= 0 && arr[right] > arr[pivot]) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // pivot 자리 교환
        swap(arr, pivot, right);
        return right;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
