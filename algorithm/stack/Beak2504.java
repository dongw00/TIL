package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beak2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        if (str.length % 2 == 1) {
            System.out.println(0);
            System.exit(0);
        }

        Stack<String> stk = new Stack<>();
        int ans = 0;
        int tmp = 1;
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "(":
                    tmp *= 2;
                    stk.push("(");
                    break;
                case "[":
                    tmp *= 3;
                    stk.push("[");
                    break;
                case ")":
                    if (stk.isEmpty() || !stk.peek().equals("(")) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    if (str[i - 1].equals("(")) {
                        ans += tmp;
                    }
                    stk.pop();
                    tmp /= 2;
                    break;
                case "]":
                    if (stk.isEmpty() || !stk.peek().equals("[")) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    if (str[i - 1].equals("[")) {
                        ans += tmp;
                    }
                    stk.pop();
                    tmp /= 3;
                    break;
            }
        }
        System.out.println(ans);
    }
}
