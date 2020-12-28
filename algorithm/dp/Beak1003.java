package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1003 {
    static int[] top = new int[41];
    static int[] down = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        down[1] = 1;
        while (t-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0)
                System.out.println("1 0");
            else {
                //System.out.println(topdown(target - 1) + " " + topdown(target));
                System.out.println(bottomup(target - 1) + " " + bottomup(target));
            }
        }
    }

    private static int topdown(int n) {
        if (top[n] > 0)
            return top[n];

        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            top[n] = 1;
            return 1;
        }
        top[n] = topdown(n - 1) + topdown(n - 2);
        return top[n];
    }

    private static int bottomup(int n) {
        if (down[n] > 0)
            return down[n];
        for (int i = 2; i <= n; i++) {
            down[i] = down[i - 2] + down[i - 1];
        }
        return down[n];
    }
}
