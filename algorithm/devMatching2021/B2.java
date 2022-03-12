package devMatching2021;

import java.util.Arrays;

public class B2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows + 1][columns + 1];

        int idx = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = idx++;
            }
        }

        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int x1 = queries[k][0];
            int y1 = queries[k][1];

            int x2 = queries[k][2];
            int y2 = queries[k][3];

            int tmp = arr[x1][y1];
            int min = tmp;

            for (int i = x1 + 1; i <= x2; i++) {
                min = Math.min(min, arr[i][y1]);
                arr[i - 1][y1] = arr[i][y1];
            }
            for (int i = y1 + 1; i <= y2; i++) {
                min = Math.min(min, arr[x2][i]);
                arr[x2][i - 1] = arr[x2][i];
            }
            for (int i = x2 - 1; i >= x1; i--) {
                min = Math.min(min, arr[i][y2]);
                arr[i + 1][y2] = arr[i][y2];
            }
            for (int i = y2 - 1; i > y1; i--) {
                min = Math.min(min, arr[x1][i]);
                arr[x1][i + 1] = arr[x1][i];
            }

            arr[x1][y1 + 1] = tmp;
            ans[k] = min;
        }
        return ans;
    }
}
