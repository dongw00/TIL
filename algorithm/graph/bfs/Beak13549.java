package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak13549 {

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
            int x = p.x;
            int time = p.time;

            if (x == k) {
                if (min <= time) {
                    break;
                }
                min = time;
            }

            if (x * 2 <= MAX && !visited[x * 2]) {
                queue.add(new Pair(x * 2, time));
                visited[x * 2] = true;
            }

            if (x - 1 >= 0 && !visited[x - 1]) {
                queue.add(new Pair(x - 1, time + 1));
                visited[x - 1] = true;
            }

            if (x + 1 <= MAX && !visited[x + 1]) {
                queue.add(new Pair(x + 1, time + 1));
                visited[x + 1] = true;
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
