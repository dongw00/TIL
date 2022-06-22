package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beak16637 {

    static int ans;
    static List<Character> ops;
    static List<Integer> nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        ans = 0;
        ops = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }
            nums.add(Character.getNumericValue(c));
        }

        dfs(nums.get(0), 0);
        System.out.println(ans);
    }

    public static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            default:
                return -1;
        }
    }

    public static void dfs(int res, int idx) {
        if (idx >= ops.size()) {
            ans = Math.max(ans, res);
            return;
        }

        // 괄호가 없는경우
        int res1 = calc(ops.get(idx), res, nums.get(idx + 1));
        dfs(res1, idx + 1);

        // 괄호가 있는 경우
        if (idx + 1 < ops.size()) {
            int res2 = calc(ops.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));

            dfs(calc(ops.get(idx), res, res2), idx + 2);
        }
    }
}
