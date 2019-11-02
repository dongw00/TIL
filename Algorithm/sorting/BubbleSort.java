package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 9, 2, 4 };

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}

		for (int a : arr)
			System.out.print(a + " ");
	}
}
