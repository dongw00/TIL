package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Beak9663 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        System.out.println(backtracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>()));
    }

    public static int backtracking(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == n) {
            return 1;
        }

        int ans = 0;
        for (int col = 0; col < n; col++) {
            int curDiagonal = row - col;
            int curAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(curDiagonal) || antiDiagonals.contains(curAntiDiagonal)) {
                continue;
            }

            cols.add(col);
            diagonals.add(curDiagonal);
            antiDiagonals.add(curAntiDiagonal);

            ans += backtracking(row + 1, diagonals, antiDiagonals, cols);

            cols.remove(col);
            diagonals.remove(curDiagonal);
            antiDiagonals.remove(curAntiDiagonal);
        }

        return ans;
    }
}