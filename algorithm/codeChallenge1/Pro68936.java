package codeChallenge1;

import java.util.Arrays;

public class Pro68936 {

    static int[] ans;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

    public static int[] solution(int[][] arr) {
        ans = new int[2];
        quad(arr, 0, 0, arr.length);
        return ans;
    }

    public static void quad(int[][] arr, int x, int y, int n) {
        if (n == 1) {
            ans[arr[x][y]]++;
            return;
        }

        if (isBlock(arr, x, y, n)) {
            return;
        }

        quad(arr, x, y, n / 2);
        quad(arr, x, y + n / 2, n / 2);
        quad(arr, x + n / 2, y, n / 2);
        quad(arr, x + n / 2, y + n / 2, n / 2);
    }

    public static boolean isBlock(int[][] arr, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[x][y] != arr[i][j])
                    return false;
            }
        }

        ans[arr[x][y]]++;
        return true;
    }
}
