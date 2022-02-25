package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Beak1495 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);

        dp[s] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int volume = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j <= m; j++) {
                if (dp[j] == i - 1) {
                    int a = j + volume;
                    int b = j - volume;

                    if (0 <= a && a <= m) {
                        set.add(a);
                    }

                    if (0 <= b && b <= m) {
                        set.add(b);
                    }
                }
            }

            for (int el : set) {
                dp[el] = i;
            }
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[i] == n) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
