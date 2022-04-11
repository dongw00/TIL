package dp;

import java.util.Arrays;

/**
 * 스티커 모으기(2)
 * https://programmers.co.kr/learn/courses/30/lessons/12971
 */
public class Pro12971 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }

    public static int solution(int[] sticker) {
        if (sticker.length <= 3) {
            return Arrays.stream(sticker).max().getAsInt();
        }

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp1[0] = dp1[1] = sticker[0];

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        dp1[sticker.length - 1] = dp1[sticker.length - 2];
        dp2[sticker.length - 1] = Math.max(dp2[sticker.length - 2], dp2[sticker.length - 3] + sticker[sticker.length - 1]);

        return Math.max(dp1[sticker.length - 1], dp2[sticker.length - 1]);
    }
}
