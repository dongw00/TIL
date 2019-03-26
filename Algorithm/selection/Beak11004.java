package selection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak11004 {
	private static int quickSelect(int[] arr, int start, int end, int k) {
		if (start <= end) {
			int pivot = partition(arr, start, end);

			if (pivot == k)
				return arr[pivot];
			else if (pivot > k)
				return quickSelect(arr, start, pivot - 1, k);
			else
				return quickSelect(arr, pivot + 1, end, k);
		}
		return Integer.MIN_VALUE;
	}

	private static int partition(int[] arr, int start, int end) {
		int i = start - 1;

		for (int j = start; j <= end; j++) {
			if (arr[j] < arr[end]) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		bw.write(quickSelect(arr, 0, n - 1, k - 1) + "\n");
		bw.flush();
	}
}
