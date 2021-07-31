package contest.hcard;

import java.util.HashMap;
import java.util.Map;

public class B1 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"BW", "RY", "BY"}, new int[]{9000, 10000}));
        System.out.println(solution(new String[]{"RG", "WR", "BW", "GG"}, new int[]{5000, 6000}));
        System.out.println(solution(new String[]{"RG", "WR", "BW", "GG"}, new int[]{2000, 6000}));
    }

    public static int solution(String[] colors, int[] prices) {
        Map<Character, Integer> topMap = new HashMap<>();
        Map<Character, Integer> bottomMap = new HashMap<>();

        char[] COLOR_LIST = new char[]{'B', 'W', 'R', 'Y', 'G'};

        for (String color : colors) {
            char top = color.charAt(0);
            char bottom = color.charAt(1);

            topMap.put(top, topMap.getOrDefault(top, 0) + 1);
            bottomMap.put(bottom, bottomMap.getOrDefault(bottom, 0) + 1);
        }
        int ans = 0;

        for (char key : topMap.keySet()) {
            if (bottomMap.getOrDefault(key, 0) > 0) {
                ans += prices[0];
                topMap.put(key, topMap.get(key) - 1);
                bottomMap.put(key, bottomMap.get(key) - 1);
            }
        }

        int rest = 0;
        for (char key : COLOR_LIST) {
            int a = topMap.getOrDefault(key, 0);
            int b = bottomMap.getOrDefault(key, 0);

            if (a > 0 || b > 0) {
                if (a > 0 && b > 0) {
                    ans += prices[1];
                } else {
                    rest++;
                }
            }
        }

        ans += Math.min(rest / 2 * prices[1], 2 * prices[0]);

        return ans;
    }
}
