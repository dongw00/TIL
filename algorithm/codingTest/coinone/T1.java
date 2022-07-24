package codingTest.coinone;

import java.util.Arrays;
import java.util.Stack;

public class T1 {

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(solution(new int[]{500, 500, -1000, 500, 500, 500, 500, -1500})));
        System.out.println(
            Arrays.toString(solution(new int[]{500, 1000, -300, 200, -400, 100, -100})));
        System.out.println(
            Arrays.toString(solution(new int[]{500, 1000, 2000, -1000, -1500, 500})));

    }

    public static int[] solution(int[] deposit) {
        Stack<Integer> stk = new Stack<>();

        for (int el : deposit) {
            if (el > 0) {
                stk.push(el);
                continue;
            }
            int tmp = stk.pop() + el;
            if (tmp >= 0) {
                if (tmp > 0) {
                    stk.push(tmp);
                }
            } else {
                while (true) {
                    tmp += stk.pop();
                    if (tmp >= 0) {
                        if (tmp > 0) {
                            stk.push(tmp);
                        }
                        break;
                    }
                }
            }
        }

        int[] ans = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}
