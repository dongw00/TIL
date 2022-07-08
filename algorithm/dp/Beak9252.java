package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Beak9252 {

    static char[] a, b;
    static int[][] dp;
    static List<Character> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp[a.length][b.length] + "\n");

        getLCS(a.length, b.length);

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + "");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    public static void getLCS(int x, int y) {
        if (x == 0 || y == 0) {
            return;
        }

        if (a[x - 1] == b[y - 1]) {
            list.add(a[x - 1]);
            getLCS(x - 1, y - 1);
        } else {
            if (dp[x - 1][y] > dp[x][y - 1]) {
                getLCS(x - 1, y);
            } else {
                getLCS(x, y - 1);
            }
        }
    }
}
