package stringProblem;

import java.io.*;
import java.util.*;

public class Beak9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stk.push(str.charAt(i));

            if (stk.size() >= target.length()) {
                boolean flag = true;
                for (int j = 0; j < target.length(); j++) {
                    if (stk.get(stk.size() - target.length() + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < target.length(); j++) {
                        stk.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
