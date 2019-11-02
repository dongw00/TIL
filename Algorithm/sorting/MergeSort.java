package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 9, 2, 4 };

		sort(arr, 0, arr.length - 1);

		for (int a : arr)
			System.out.print(a + " ");
	}

	public static void merge(int arr[], int l, int m, int r) {
		int i = l, j = m + 1, k = l;
		int tmp[] = new int[arr.length];

		while (i <= m && j <= r) {
			if (arr[i] <= arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}

		while (i <= m)
			tmp[k++] = arr[i++];

		while (j <= r)
			tmp[k++] = arr[j++];

		for (i = l; i <= r; i++)
			arr[i] = tmp[i];
	}

	private static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
}
