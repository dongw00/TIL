package codeChallenge2;

import java.util.Stack;

public class Pro76502 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int size = s.length() - 1;

        int ans = 0;


        for (int i = 0; i < size; i++) {
            Stack<Character> stk = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == ']' || c == ')' || c == '}') {
                    if (stk.isEmpty() || !(stk.peek() == '[' && c == ']')
                            && !(stk.peek() == '(' && c == ')')
                            && !(stk.peek() == '{' && c == '}')) {
                        stk.push('f');
                        break;
                    }
                    stk.pop();
                } else {
                    stk.add(c);
                }
            }

            if (stk.isEmpty()) {
                ans++;
            }

            s = s.substring(1) + s.charAt(0);
        }

        return ans;
    }
}
