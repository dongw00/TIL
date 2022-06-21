package selection;

public class QuickSelection {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(quickSelection(arr, 0, arr.length - 1, 5));
        System.out.println(quickSelection(arr, 0, arr.length - 1, 6));
    }

    public static int quickSelection(int[] arr, int left, int right, int k) {
        int pivot = partition(arr, left, right);

        if (pivot == k) {
            return arr[pivot];
        } else if (pivot > k) {
            quickSelection(arr, left, pivot - 1, k);
        } else {
            quickSelection(arr, pivot + 1, right, k);
        }
        return -1;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        int i = left + 1, j = right;

        while (i <= j) {
            while (arr[i] <= pivot && i <= right) {
                i++;
            }
            while (arr[j] >= pivot && j >= left + 1) {
                j--;
            }
        }
        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
