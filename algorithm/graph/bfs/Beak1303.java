package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1303 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[m][n];
        boolean[][] check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int blue = 0, white = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    if (arr[i][j] == 'W') {
                        white += Math.pow(bfs(arr, check, 'W', i, j), 2);
                    }

                    if (arr[i][j] == 'B') {
                        blue += Math.pow(bfs(arr, check, 'B', i, j), 2);
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    public static int bfs(char[][] arr, boolean[][] check, char type, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        check[x][y] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) {
                    if (!check[nx][ny] && arr[nx][ny] == type) {
                        queue.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
