package dp;

public class LeetCode42 {

    public static void main(String[] args) {
        int[] heights_1 = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights_2 = new int[] {4, 2, 0, 3, 2, 5};

        assert trap(heights_1) == 5 : "Correct";
        assert trap(heights_2) == 9 : "Correct";
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    ans += (leftMax - height[left]);
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    ans += (rightMax - height[right]);
                right++;
            }
        }

        return ans;
    }
}
