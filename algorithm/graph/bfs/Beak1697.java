package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1697 {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX + 1];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, 0));
        visited[n] = true;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int now = p.x;
            int time = p.time;

            if (now == k) {
                if (min > time) {
                    min = time;
                } else {
                    break;
                }
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.add(new Pair(now - 1, time + 1));
                visited[now - 1] = true;
            }

            if (now + 1 <= MAX && !visited[now + 1]) {
                queue.add(new Pair(now + 1, time + 1));
                visited[now + 1] = true;
            }

            if (now * 2 <= MAX && !visited[now * 2]) {
                queue.add(new Pair(now * 2, time + 1));
                visited[now * 2] = true;
            }
        }

        System.out.println(min);
    }

    static class Pair {

        int x, time;

        Pair(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}
