package selection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Beak11004 {
	static int[] arr;

	private static int quickSelect(int start, int end, int k) {
		if (start <= end) {
			int pivot = partition(start, end);

			if (pivot == k)
				return arr[pivot];
			else if (pivot > k)
				return quickSelect(start, pivot - 1, k);
			else
				return quickSelect(pivot + 1, end, k);
		}
		return Integer.MIN_VALUE;
	}

	private static int partition(int start, int end) {
		int pivot = start + new Random().nextInt(end - start + 1);

		swap(end, pivot);

		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < arr[end]) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, end);
		return i + 1;
	}

	private static void swap(int a, int b) {
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

		arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		bw.write(quickSelect(0, n - 1, k - 1) + "\n");
		bw.flush();

		br.close();
		bw.close();
	}
}
