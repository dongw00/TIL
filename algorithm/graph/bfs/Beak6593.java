package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak6593 {

    static int[] dx = { 0, 0, 1, -1, 0, 0 };
    static int[] dy = { -1, 1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    private static class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0) {
                break;
            }

            char[][][] arr = new char[l][r][c];
            int[][][] dist = new int[l][r][c];

            Queue<Pair> queue = new LinkedList<>();

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        arr[i][j][k] = str.charAt(k);

                        if (arr[i][j][k] == 'S') {
                            queue.add(new Pair(i, j, k));
                        }
                    }
                }
                br.readLine();
            }

            boolean check = false;
            Outter: while (!queue.isEmpty()) {
                Pair p = queue.remove();

                for (int i = 0; i < dx.length; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];

                    if (0 <= nx && nx < l && 0 <= ny && ny < r && 0 <= nz && nz < c) {
                        if (arr[nx][ny][nz] == '.' && dist[nx][ny][nz] == 0) {
                            queue.add(new Pair(nx, ny, nz));
                            dist[nx][ny][nz] = dist[p.x][p.y][p.z] + 1;
                        } else if (arr[nx][ny][nz] == 'E') {
                            System.out.println("Escaped in " + (dist[p.x][p.y][p.z] + 1) + " minute(s).");
                            check = true;
                            break Outter;
                        }
                    }
                }
            }

            if (!check)
                System.out.println("Trapped!");
        }
    }
}