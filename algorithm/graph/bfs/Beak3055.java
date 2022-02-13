package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak3055 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];

        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> wqueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                char in = str.charAt(j);
                arr[i][j] = in;

                if (in == 'S') {
                    queue.add(new Pair(i, j, 0));
                } else if (in == '*') {
                    wqueue.add(new Pair(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = wqueue.size();
            // move water
            for (int t = 0; t < size; t++) {
                Pair p = wqueue.remove();

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                        if (arr[nx][ny] == '.') {
                            wqueue.add(new Pair(nx, ny, 0));
                            arr[nx][ny] = '*';
                        }
                    }
                }
            }

            size = queue.size();
            for (int t = 0; t < size; t++) {
                Pair p = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                        if (arr[nx][ny] == 'D') {
                            System.out.println(p.cnt + 1);
                            System.exit(0);
                        }

                        if (arr[nx][ny] == '.') {
                            queue.add(new Pair(nx, ny, p.cnt + 1));
                            arr[nx][ny] = 'X';
                        }
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }

    public static class Pair {

        int x, y, cnt;

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
