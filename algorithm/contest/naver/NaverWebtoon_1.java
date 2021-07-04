package contest.naver;

import java.util.*;

public class NaverWebtoon_1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 13000, 88000, 10000 }, new int[] { 30, 20 }));
    }

    public static int solution(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int ans = 0;
        int idx = discounts.length - 1;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (idx >= 0) {
                ans += prices[i] * (1 - (discounts[idx--] / (float) 100));
            } else {
                ans += prices[i];
            }
        }

        return ans;
    }
}
