package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Pro42884 {

    public static void main(String[] args) {
        Pro42884 p = new Pro42884();
        System.out.println(p.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cnt = 1;
        int prev = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (prev >= routes[i][0]) {
                continue;
            }

            prev = routes[i][1];
            cnt++;
        }
        return cnt;
    }
}
