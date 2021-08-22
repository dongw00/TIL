package contest.kakao.intern_2021;

import java.util.Arrays;

public class Kakao_거리두기_dfs {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

    public static int[] solution(String[][] places) {
        int[] ans = new int[5];
        int idx = 0;
        for (String[] place : places) {
            try {
                boolean[][] check = new boolean[5][5];

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (place[i].charAt(j) == 'P') {
                            check[i][j] = true;
                            dfs(place, check, i, j, 0);
                            check[i][j] = false;
                        }
                    }
                }
                ans[idx++] = 1;
            } catch (Exception e) {
                ans[idx++] = 0;
            }
        }

        return ans;
    }

    public static void dfs(String[] place, boolean[][] check, int x, int y, int cnt)
        throws Exception {
        if (cnt > 2) {
            return;
        }

        if (0 < cnt && place[x].charAt(y) == 'P') {
            throw new Exception();
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                if (!check[nx][ny] && place[nx].charAt(ny) != 'X') {
                    check[nx][ny] = true;
                    dfs(place, check, nx, ny, cnt + 1);
                    check[nx][ny] = false;
                }
            }
        }
    }
}
