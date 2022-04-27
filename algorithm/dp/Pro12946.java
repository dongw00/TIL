package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro12946 {
    static List<int[]> list;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(2)));
        System.out.println(Arrays.deepToString(solution(3)));
    }

    public static int[][] solution(int n) {
        list = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
        }

        return ans;
    }

    private static void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};

        if (n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            list.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
