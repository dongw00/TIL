package SegmentTree;

import java.io.*;
import java.util.*;

public class Beak2042 {
	static long arr[];
	static long tree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new long[n];
		tree = new long[n * 4];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(1, 0, n - 1);

		m += k;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int get = Integer.parseInt(st.nextToken());

			if (get == 1) {
				int pos = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());

				long diff = value - arr[pos - 1];
				arr[pos - 1] = value;
				update(1, 0, n - 1, pos - 1, diff);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				System.out.println(sum(1, 0, n - 1, left - 1, right - 1));
			}
		}
	}

	private static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) / 2;

		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}

	private static void update(int node, int start, int end, int index, long diff) {
		if (!(start <= index && index <= end))
			return;

		tree[node] += diff;

		if (start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, index, diff);
			update(node * 2 + 1, mid + 1, end, index, diff);
		}
	}

	private static long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

}
