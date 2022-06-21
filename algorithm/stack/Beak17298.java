package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Beak17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                ans[stk.pop()] = arr[i];
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            ans[stk.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int el : ans) {
            bw.write(el + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
