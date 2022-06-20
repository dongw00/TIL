package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beak1874 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        try {
            for (int i = 1; i <= n; i++) {
                while (!stk.isEmpty() && arr[idx] == stk.peek()) {
                    sb.append("-\n");
                    idx++;
                    stk.pop();
                }

                sb.append("+\n");
                stk.push(i);
            }
        } catch (Exception e) {
            System.out.println("NO");
            System.exit(0);
        }

        while (!stk.isEmpty() && arr[idx] == stk.peek()) {
            sb.append("-\n");
            idx++;
            stk.pop();
        }

        System.out.println(!stk.isEmpty() ? "NO" : sb);
    }

}
