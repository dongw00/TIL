package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak12851 {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX + 1];

        Queue<Pair> queue = new LinkedList<>();
        int cnt = 1;
        int min = Integer.MAX_VALUE;

        queue.add(new Pair(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int now = p.x;
            int time = p.time;
            visited[now] = true;

            if (now == k) {
                if (min > time) {
                    min = time;
                } else if (min == time) {
                    cnt++;
                } else {
                    continue;
                }
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.add(new Pair(now - 1, time + 1));
            }

            if (now + 1 <= MAX && !visited[now + 1]) {
                queue.add(new Pair(now + 1, time + 1));
            }

            if (now * 2 <= MAX && !visited[now * 2]) {
                queue.add(new Pair(now * 2, time + 1));
            }
        }

        System.out.println(min);
        System.out.println(cnt);
    }

    static class Pair {

        int x, time;

        Pair(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
