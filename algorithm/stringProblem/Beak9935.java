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

             if (stk.peek() == target.charAt(target.length() - 1) && stk.size() >= target.length()) {
                 int idx = target.length() - 2;
                 boolean flag = false;

                 for (int j = stk.size() - 2; j >= stk.size() - target.length(); j--) {
                     if (stk.get(j) != target.charAt(idx--)) {
                         flag = true;
                         break;
                     }
                 }

                 if (!flag) {
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
