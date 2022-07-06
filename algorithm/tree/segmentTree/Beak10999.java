package tree.segmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak10999 {

    static long[] arr;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n * 4];
        lazy = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 0, n - 1);

        m += k;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int get = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

					if (get == 1) {
						long value = Long.parseLong(st.nextToken());

						update_range(1, 0, n - 1, left - 1, right - 1, value);
					} else {
						System.out.println(sum(1, 0, n - 1, left - 1, right - 1));
					}
        }
    }

    private static long init(int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			}

        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    private static void update_range(int node, int start, int end, int left, int right,
        long value) {
        update_lazy(node, start, end);

			if (left > end || right < start) {
				return;
			}

        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * value;

            if (start != end) {
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }

            return;
        }

        int mid = (start + end) / 2;

        update_range(node * 2, start, mid, left, right, value);
        update_range(node * 2 + 1, mid + 1, end, left, right, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static void update_lazy(int node, int start, int end) {
			if (lazy[node] == 0) {
				return;
			}

        tree[node] += (end - start + 1) * lazy[node];

        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }

        lazy[node] = 0;
    }

    private static long sum(int node, int start, int end, int left, int right) {
        update_lazy(node, start, end);

			if (left > end || right < start) {
				return 0;
			}

			if (left <= start && end <= right) {
				return tree[node];
			}

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left,
            right);
    }

}
