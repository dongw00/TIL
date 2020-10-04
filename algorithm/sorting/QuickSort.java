package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 4, 12, 5, 0, 2, 4, 1, 2};
        quickSort(arr);

        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot)
                low++;
            while (arr[high] > pivot)
                high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
