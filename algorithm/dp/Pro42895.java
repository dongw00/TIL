package dp;

import java.util.HashSet;
import java.util.Set;

public class Pro42895 {

    public static void main(String[] args) {
        Pro42895 p = new Pro42895();
        System.out.println(p.solution(5, 12));
        System.out.println(p.solution(2, 11));
    }

    public int solution(int N, int number) {
        int ans = -1;
        Set<Integer>[] set = new Set[9];

        int tmp = N;

        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
            set[i].add(tmp);
            tmp = tmp * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : set[j]) {
                    for (int b : set[i - j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(b - a);
                        set[i].add(a * b);

                        if (b != 0) {
                            set[i].add(a / b);
                        }
                        if (a != 0) {
                            set[i].add(b / a);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            if (set[i].contains(number)) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
