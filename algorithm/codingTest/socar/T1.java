package codingTest.socar;

import java.util.LinkedList;
import java.util.Queue;

public class T1 {

    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) {
        System.out.println(
            solution(new String[][]{{"XXXXX", "OOSXO", "OOXOO"}, {"XEOOO", "OXXXO", "OOOOX"}}));
        System.out.println(
            solution(new String[][]{{"OOOOO", "OOOOO", "OOEOO", "OOOOO", "OOOOO"},
                {"OOOOO", "OXXXO", "OXXXO", "OXXXO", "OOOOO"},
                {"OOOOO", "OOOOO", "OOSOO", "OOOOO", "OOOOO"}}));
        System.out.println(
            solution(new String[][]{{"SOXX", "OOXX"}, {"XXOO", "XXOE"}}));
    }

    public static int solution(String[][] map3d) {
        Queue<Pair> queue = new LinkedList<>();

        int h = map3d.length;
        int m = map3d[0].length;
        int n = map3d[0][0].length();

        int endX = 0, endY = 0, endZ = 0;

        int[][][] arr = new int[h][m][n];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = map3d[k][i].charAt(j);
                    arr[k][i][j] = c == 'X' ? -1 : 0;
                    if (c == 'S') {
                        queue.add(new Pair(i, j, k));
                    } else if (c == 'E') {
                        endX = i;
                        endY = j;
                        endZ = k;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && 0 <= nz && nz < h) {
                    int tmp = arr[p.z][p.x][p.y] + 1;
                    int tmp2 = arr[nz][nx][ny];

                    if (nx == endX && ny == endY && nz == endZ) {
                        if (tmp2 == 0) {
                            return tmp;
                        }
                        return Math.min(tmp, tmp2);
                    } else if (tmp2 == 0) {
                        arr[nz][nx][ny] = tmp;
                        queue.add(new Pair(nx, ny, nz));
                    }
                }
            }
        }
        return arr[endZ][endX][endY] == 0 ? -1 : arr[endZ][endX][endY];
    }

    static class Pair {

        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
