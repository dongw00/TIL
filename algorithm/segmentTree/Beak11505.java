package segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak11505 {

    static final int MOD = 1000000007;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tree = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, n - 1, 1);

        m += k;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int mod = Integer.parseInt(st.nextToken());

            if (mod == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int num = Integer.parseInt(st.nextToken());

                arr[b] = num;
                update(0, n - 1, 1, b, num);
            } else {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;

                bw.write(multiply(0, n - 1, b, c, 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    public static long update(int start, int end, int node, int idx, int num) {
        if (idx < start || end < idx) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = num;
        }

        int mid = (start + end) / 2;
        return tree[node] =
            (update(start, mid, node * 2, idx, num) * update(mid + 1, end, node * 2 + 1, idx,
                num))
                % MOD;
    }

    public static long multiply(int start, int end, int left, int right, int node) {
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return (multiply(start, mid, left, right, node * 2) * multiply(mid + 1, end, left, right,
            node * 2 + 1)) % MOD;
    }
}
