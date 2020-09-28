package Algorithm.backtracking;

import java.io.*;

/**
 * Beak9663
 */
public class Beak9663 {

    static int[] col;
    static int cnt = 0, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            col[1] = i;
            nQueen(1);
        }
        System.out.println(cnt);
    }

    public static void nQueen(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            col[row + 1] = i;
            if (isPossible(row + 1))
                nQueen(row + 1);
            else
                col[row + 1] = 0;
        }

        col[row] = 0;
    }

    public static boolean isPossible(int row) {
        for (int i = 1; i < row; i++) {
            if (col[i] == col[row])
                return false;
            if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
                return false;
        }
        return true;
    }
}