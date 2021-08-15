package contest.kakao.intern_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class kakao_표편집 {

    public static void main(String[] args) {
        System.out.println(
            solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2,
            new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = k;

        Stack<Integer> stk = new Stack<>();
        int size = n;

        for (String c : cmd) {
            StringTokenizer st = new StringTokenizer(c);
            String command = st.nextToken();

            switch (command) {
                case "U":
                    idx -= Integer.parseInt(st.nextToken());
                    break;
                case "D":
                    idx += Integer.parseInt(st.nextToken());
                    break;
                case "C":
                    stk.push(idx);
                    size--;
                    if (idx == size) {
                        idx--;
                    }
                    break;
                case "Z":
                    int tmp = stk.pop();
                    if (idx >= tmp) {
                        idx++;
                    }
                    size++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }

        while (!stk.isEmpty()) {
            sb.insert(stk.pop(), "X");
        }

        return sb.toString();
    }
}
