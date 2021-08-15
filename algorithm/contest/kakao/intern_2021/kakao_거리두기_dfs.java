package contest.kakao.intern_2021;

import java.util.Arrays;

public class kakao_거리두기_dfs {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[] ans;

    public static void main(String[] args) {

        System.out.println(
            Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

    public static int[] solution(String[][] places) {
        ans = new int[]{1, 1, 1, 1, 1};
        int idx = 0;

        for (String[] place : places) {
            boolean[][] check = new boolean[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        check[i][j] = true;
                        dfs(place, check, i, j, 0, idx);
                        check[i][j] = false;
                    }
                }
            }

            idx++;
        }
        return ans;
    }

    public static void dfs(String[] place, boolean[][] check, int x, int y, int cnt, int idx) {
        if (cnt > 2) {
            return;
        }

        if (0 < cnt && place[x].charAt(y) == 'P') {
            ans[idx] = 0;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                if (!check[nx][ny] && place[nx].charAt(ny) != 'X') {
                    check[nx][ny] = true;
                    dfs(place, check, nx, ny, cnt + 1, idx);
                    check[nx][ny] = false;
                }
            }
        }
    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
