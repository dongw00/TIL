package sorting;

import java.util.ArrayList;
import java.util.List;

public class Prog42746 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int[] {0, 0, 0, 0, 0}));
    }

    public static String solution(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int n : num) {
            list.add(n);
        }

        list.sort((a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            if (list.get(0) == 0)
                return "0";
            sb.append(n);
        }
        return sb.toString();
    }
}
