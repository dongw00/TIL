package greedy;

import java.util.HashSet;
import java.util.Set;

public class Pro42862 {

    public static void main(String[] args) {
        Pro42862 p = new Pro42862();

        System.out.println(p.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(p.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(p.solution(3, new int[]{3}, new int[]{1}));
        System.out.println(p.solution(5, new int[]{2, 4}, new int[]{1, 3, 4, 5}));
        System.out.println(p.solution(5, new int[]{1, 2, 4}, new int[]{2, 4, 5}));
        System.out.println(p.solution(5, new int[]{1, 2, 4}, new int[]{2, 3, 4, 5}));
        System.out.println(p.solution(6, new int[]{2, 4, 5}, new int[]{1, 3, 6}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        for (int el : lost) {
            lostSet.add(el);
        }

        int lostCnt = 0;
        for (int el : reserve) {
            if (!lostSet.contains(el)) {
                reserveSet.add(el);
            } else {
                lostCnt++;
                lostSet.remove(el);
            }
        }

        int cnt = 0;
        for (int el : lostSet) {
            if (reserveSet.contains(el - 1)) {
                cnt++;
                reserveSet.remove(el - 1);
            } else if (reserveSet.contains(el + 1)) {
                cnt++;
                reserveSet.remove(el + 1);
            }
        }

        return n - (lost.length - lostCnt) + cnt;
    }
}
