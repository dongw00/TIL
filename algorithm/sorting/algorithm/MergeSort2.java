package sorting.algorithm;

import java.util.Arrays;

public class MergeSort2 {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left];
        int l = left, r = mid;
        int idx = 0;

        while (l < mid && r < right) {
            if (arr[l] < arr[r]) {
                tmp[idx++] = arr[l++];
            } else {
                tmp[idx++] = arr[r++];
            }
        }

        while (l < mid) {
            tmp[idx++] = arr[l++];
        }
        while (r < right) {
            tmp[idx++] = arr[r++];
        }
        for (int i = left; i < right; i++) {
            arr[i] = tmp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 500, -30, 50, 3, 4, 5, 10, -1, 0, 11, 1, 950, 2000};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
