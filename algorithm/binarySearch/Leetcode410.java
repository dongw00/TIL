package binarySearch;

public class Leetcode410 {

    public static void main(String[] args) {
        Leetcode410 leetcode = new Leetcode410();
        System.out.println(leetcode.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(leetcode.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(leetcode.splitArray(new int[]{1, 4, 4}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int max = 0;
        for (int i = 0; i < m; i++) {
            max += nums[i];
        }

        int sum = max;
        for (int i = m; i < nums.length; i++) {
            sum += nums[i] - nums[i - m];
            max = Math.max(sum, max);
        }

        return max;
    }
}
