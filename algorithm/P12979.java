public class P12979 {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
    }

    public static int solution(int n, int[] stations, int w) {
        int baseLeft = 0, baseRight = 0;
        int left = 0, right = 0;

        int ans = 0;
        for (int el : stations) {
            left = baseRight;

            baseLeft = el - w;
            baseRight = el + w;

            if (baseLeft < 0) baseLeft = 0;
            if (baseRight > n) baseRight = n;

            right = baseLeft - 1;
            if (right < 0 || left >= right) continue;

            ans += Math.ceil((right - left) / (float) (w * 2 + 1));
        }

        if (baseRight != n) {
            ans += Math.ceil((n - baseRight) / (float) (w * 2 + 1));
        }
        return ans;
    }
}
