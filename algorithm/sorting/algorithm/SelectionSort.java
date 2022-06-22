package sorting.algorithm;

import java.util.Arrays;

/**
 * Time complexity O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{45, 100, 2, 3, 5, 0, -50, 30, 70, -100, 5000, 23, 0, 0, 5, 1, 1, 1};
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
