package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = -Integer.parseInt(br.readLine());
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(k, 0));
        visited[k] = true;

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int x = p.x;
            int cnt = p.cnt;

            if (x == 0) {
                if (min > cnt) {
                    min = cnt;
                }
            }

            if (min <= cnt) {
                continue;
            }

            for (int el : arr) {
                int nx = x + el;
                if (0 <= nx && nx <= k && !visited[nx]) {
                    queue.add(new Pair(nx, cnt + 1));
                    visited[nx] = true;
                }
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static class Pair {

        int x, cnt;

        Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

}
