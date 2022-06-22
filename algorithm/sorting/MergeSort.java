package sorting;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int leftIdx = left;
        int rightIdx = mid + 1;
        int sortedIdx = left;

        int[] tmp = new int[right + 1];

        while (leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                tmp[sortedIdx++] = arr[leftIdx++];
            } else {
                tmp[sortedIdx++] = arr[rightIdx++];
            }
        }

        if (leftIdx > mid) {
            for (int i = rightIdx; i <= right; i++) {
                tmp[sortedIdx++] = arr[i];
            }
        } else {
            for (int i = leftIdx; i <= mid; i++) {
                tmp[sortedIdx++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 100, 40, 30, 29, 49, 2, 1, 0, 5, 1000, 59, 23, 14};

        MergeSort sort = new MergeSort();
        sort.mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
