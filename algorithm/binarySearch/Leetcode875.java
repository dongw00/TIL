package binarySearch;

public class Leetcode875 {

    public static void main(String[] args) {
        Leetcode875 leetcode = new Leetcode875();
        System.out.println(leetcode.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(leetcode.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(leetcode.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(leetcode.minEatingSpeed(new int[]{1000000000}, 2));
        System.out.println(leetcode.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (eat(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int eat(int[] piles, int mid) {
        int cnt = 0;
        for (int p : piles) {
            cnt += p / mid;
            if (p % mid != 0) cnt++;
        }
        return cnt;
    }
}
