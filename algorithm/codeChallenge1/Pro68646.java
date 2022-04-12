package codeChallenge1;

public class Pro68646 {

    static final int MAX = 1000000000;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, -1, -5}));
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    public static int solution(int[] a) {
        int ans = 0;

        int left = MAX, right = MAX;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < left) {
                ans++;
                left = a[i];
            }

            if (a[a.length - 1 - i] < right) {
                ans++;
                right = a[a.length - 1 - i];
            }

            if (left == right) {
                break;
            }
        }

        return ans + (left == right ? -1 : 0);
    }
}
