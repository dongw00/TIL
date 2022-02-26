package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beak2504 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stk = new Stack<>();

        try {
            for (char c : str.toCharArray()) {
                switch (c) {
                    case ')':
                        if (stk.peek().equals("(")) {
                            stk.pop();
                            stk.push("2");
                            break;
                        } else if (!stk.peek().equals("[")) {
                            int sum = 0;
                            while (!stk.peek().equals("(") && !stk.peek().equals("[")) {
                                sum += Integer.parseInt(stk.pop());
                            }
                            if (!stk.peek().equals("(")) {
                                throw new Exception();
                            }
                            stk.pop();
                            stk.push(Integer.toString(sum * 2));
                        } else {
                            throw new Exception();
                        }
                        break;
                    case ']':
                        if (stk.peek().equals("[")) {
                            stk.pop();
                            stk.push("3");
                            break;
                        } else if (!stk.peek().equals("(")) {
                            int sum = 0;
                            while (!stk.peek().equals("(") && !stk.peek().equals("[")) {
                                sum += Integer.parseInt(stk.pop());
                            }
                            if (!stk.peek().equals("[")) {
                                throw new Exception();
                            }
                            stk.pop();
                            stk.push(Integer.toString(sum * 3));
                        } else {
                            throw new Exception();
                        }
                        break;
                    default:
                        stk.push(Character.toString(c));
                        break;
                }
            }

            int ans = 0;
            while (!stk.isEmpty()) {
                if (stk.peek().equals("(") || stk.peek().equals("[")) {
                    throw new Exception();
                }
                ans += Integer.parseInt(stk.pop());
            }
            System.out.println(ans);
        } catch (Exception e) {
            System.out.println(0);
        }

    }
}
