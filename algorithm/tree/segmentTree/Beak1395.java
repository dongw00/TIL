package tree.segmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1395 {

    static int[] tree, lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[n * 4];
        lazy = new int[n * 4];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int get = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

					if (get == 1) {
						System.out.println(sum(1, 1, n, s, e));
					} else {
						update_range(1, 1, n, s, e, 1);
					}
        }
    }

    private static void update_range(int node, int start, int end, int left, int right, int diff) {
        update_lazy(node, start, end);

			if (left > end || right < start) {
				return;
			}

        if (left <= start && end <= right) {
            tree[node] = end - start + 1 - tree[node];

            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }

            return;
        }

        int mid = (start + end) / 2;

        update_range(node * 2, start, mid, left, right, diff);
        update_range(node * 2 + 1, mid + 1, end, left, right, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static void update_lazy(int node, int start, int end) {
        if (lazy[node] != 0) {
					if (lazy[node] % 2 != 0) {
						tree[node] = (end - start + 1) - tree[node];
					}
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private static int sum(int node, int start, int end, int left, int right) {
        update_lazy(node, start, end);

			if (right < start || end < left) {
				return 0;
			} else if (left <= start && end <= right) {
				return tree[node];
			}

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left,
            right);
    }

}
