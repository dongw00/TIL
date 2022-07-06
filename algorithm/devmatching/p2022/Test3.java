package devmatching.p2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test3 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(
            Arrays.toString(test3.solution(9, 7, new int[][]{{2, 2}, {2, 3}, {2, 5}, {3, 2}, {3, 4},
                {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5}, {6, 2}, {6, 3}, {6, 4}, {6, 6},
                {7, 2},
                {7, 6}, {8, 3}, {8, 4}, {8, 5}})));
    }

    public int[] solution(int rows, int columns, int[][] lands) {
        int[][] arr = new int[rows][columns];

        // 육지 표시
        for (int[] land : lands) {
            int x = land[0] - 1;
            int y = land[1] - 1;

            arr[x][y] = 1;
        }

        // BFS
        int idx = 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] != 0) {
                    continue;
                }

                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    bfs(arr, rows, columns, i, j, -1);
                } else {
                    bfs(arr, rows, columns, i, j, idx++);
                }
            }
        }

        int[] cnt = new int[idx];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] > 1) {
                    cnt[arr[i][j]]++;
                }
            }
        }

        int min = Integer.MAX_VALUE, max = 0;
        for (int el : cnt) {
            if (el == 0) {
                continue;
            }
            min = Math.min(el, min);
            max = Math.max(el, max);
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        } else {
            return new int[]{min, max};
        }
    }

    public void bfs(int[][] arr, int rows, int columns, int x, int y, int idx) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, idx});
        arr[x][y] = idx;

        while (!queue.isEmpty()) {
            int[] tmp = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (0 > nx || nx >= rows || 0 > ny || ny >= columns || arr[nx][ny] != 0) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, tmp[2]});
                    arr[nx][ny] = tmp[2];
                }
            }
        }
    }
}
