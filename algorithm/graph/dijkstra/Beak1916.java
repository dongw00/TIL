package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak1916 {

    static final int INF = 100000001;

    static List<Pair>[] list;
    static int[] dist;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Pair(end, cost));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        boolean[] visited = new boolean[n + 1];
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();

            if (visited[p.end]) {
                continue;
            }

            visited[p.end] = true;

            for (Pair el : list[p.end]) {
                if (dist[el.end] > dist[p.end] + el.cost) {
                    dist[el.end] = dist[p.end] + el.cost;
                    pq.add(new Pair(el.end, dist[el.end]));
                }
            }
        }
    }

    static class Pair {

        int end, cost;

        Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

}
