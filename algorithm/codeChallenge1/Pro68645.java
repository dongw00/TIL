package codeChallenge1;

import java.util.Arrays;

public class Pro68645 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
    }

    public static int[] solution(int n) {
        int[][] arr = new int[n][n];

        int dir = 0;    // down: 0, right: 1, up: 2

        int i = 0, j = 0;
        arr[i][j] = 1;

        int cnt = 2;
        int limit = (n * (n + 1)) / 2;

        while (cnt <= limit) {
            if (dir == 0) {
                if (i + 1 >= n || arr[i + 1][j] > 0) {
                    dir = (dir + 1) % 3;
                } else {
                    arr[++i][j] = cnt++;
                }
            }

            if (dir == 1) {
                if (j + 1 >= n || arr[i][j + 1] > 0) {
                    dir = (dir + 1) % 3;
                } else {
                    arr[i][++j] = cnt++;
                }
            }

            if (dir == 2) {
                if (arr[i - 1][j - 1] > 0) {
                    dir = 0;
                } else {
                    arr[--i][--j] = cnt++;
                }
            }
        }

        int[] ans = new int[limit];
        int idx = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y <= x; y++) {
                ans[idx++] = arr[x][y];
            }
        }

        return ans;
    }
}
