package tree.segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak2042 {

    static long[] arr, tree;

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

        init(0, n - 1, 1);

        m += k;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int mod = Integer.parseInt(st.nextToken());

            if (mod == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long num = Long.parseLong(st.nextToken());

                long diff = num - arr[idx];
                arr[idx] = num;
                update(0, n - 1, diff, idx, 1);
            } else {
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                sb.append(sum(0, n - 1, start, end, 1)).append("\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private static void update(int start, int end, long diff, int idx, int node) {
        if (start > idx || end < idx) {
            return;
        }

        tree[node] += diff;

        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, diff, idx, node * 2);
        update(mid + 1, end, diff, idx, node * 2 + 1);
    }

    private static long sum(int start, int end, int left, int right, int node) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, left, right, node * 2) + sum(mid + 1, end, left, right,
            node * 2 + 1);
    }

}
