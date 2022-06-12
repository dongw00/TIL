package binarySearch;

public class Leetcode1011 {

    public static void main(String[] args) {
        Leetcode1011 leet = new Leetcode1011();

        System.out.println(leet.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(leet.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(leet.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int el : weights) {
            left = Math.max(left, el);
            right += el;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            int loadDay = load(weights, mid);

            if (loadDay <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int load(int[] weights, int mid) {
        int day = 1;
        int tmp = mid;
        for (int el : weights) {
            if (tmp - el < 0) {
                day++;
                tmp = mid - el;
            } else {
                tmp -= el;
            }
        }

        return day;
    }
}
