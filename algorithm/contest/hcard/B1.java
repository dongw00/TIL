package contest.hcard;

import java.util.HashMap;
import java.util.Map;

public class B1 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"RG", "WR", "BW", "GG"}, new int[]{5000, 6000}));
        System.out.println(solution(new String[]{"RG", "WR", "BW", "GG"}, new int[]{2000, 6000}));
        System.out.println(solution(new String[]{"BW", "RY", "BY"}, new int[]{9000, 10000}));
        System.out.println(solution(new String[]{"YW", "RY", "WG", "BW"}, new int[]{7561, 8945}));
        System.out.println(solution(new String[]{"BB", "BB", "BB"}, new int[]{1000, 10000}));
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
            int topValue = topMap.get(key);
            int bottomValue = bottomMap.getOrDefault(key, 0);

            if (bottomValue > 0) {
                int tmp = Math.min(topValue, bottomValue);
                ans += tmp * prices[0];
                topMap.put(key, topMap.get(key) - tmp);
                bottomMap.put(key, bottomMap.get(key) - tmp);
            }
        }

        int tmp = 0;
        for (char key : COLOR_LIST) {
            tmp += topMap.getOrDefault(key, 0) + bottomMap.getOrDefault(key, 0);
        }

        ans += Math.min(tmp / 2 * prices[1], tmp * prices[0]);
        return ans;
    }
}
