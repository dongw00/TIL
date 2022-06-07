package segmentTree;

public class SegmentTree {

    static int[] arr;

    static int[] tree;

    public static void main(String[] args) {
        arr = new int[]{1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
        tree = new int[arr.length * 4];

        init(0, arr.length - 1, 1);

        System.out.println("======== 0 ~ 12 구간 합 ========");
        System.out.println(sum(0, arr.length - 1, 1, 0, 12));

        System.out.println("======== 3 ~ 8 구간 합 ========");
        System.out.println(sum(0, arr.length - 1, 1, 3, 8));

        System.out.println("======== idx 5 => -5 수정 ========");
        update(0, arr.length - 1, 1, 5, -5);

        System.out.println("======== 3 ~ 8 구간 합 ========");
        System.out.println(sum(0, arr.length - 1, 1, 3, 8));
    }

    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static int sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int idx, int diff) {
        if (idx < start || idx > end)
            return;

        tree[node] += diff;
        if (start == end)
            return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}
