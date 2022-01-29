package contest.toss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class toss_2 {

    public static void main(String[] args) {
        solution(2, true, new int[]{1, 1, 1, 1});
        solution(2, false, new int[]{1, 2, 3, 4});
        solution(2, true, new int[]{1, 1, 2, 2});
        solution(2, true, new int[]{1, 2, 2, 3, 4, 1});
    }

    public static int[][] solution(int servers, boolean sticky, int[] requests) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < servers; i++) {
            List<Integer> tmp = new ArrayList<>();
            list.add(tmp);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int row = 0, max = 0;
        for (int el : requests) {
            if (sticky) {
                row = map.getOrDefault(el, row);
                map.put(el, row);
            }
            list.get(row).add(el);

            max = Math.max(list.get(row).size(), max);
            row = (row + 1) % servers;
        }

        int[][] ans = new int[servers][max];

        for (int i = 0; i < servers; i++) {
            for (int j = 0; j < max; j++) {
                if (list.get(i).size() == 0) {
                    break;
                }
                ans[i][j] = list.get(i).get(j);
            }
        }

        return ans;
    }
}
