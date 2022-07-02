package graph.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak1753 {

    static class Pair {

        int end, cost;

        Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static final int INF = 200001;
    static int v;
    static int[] cost;
    static List<Pair>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Pair(b, c));
        }

        cost = new int[v + 1];
        Arrays.fill(cost, INF);

        dijkstra(k);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= v; i++) {
            bw.write((cost[i] == INF ? "INF" : String.valueOf(cost[i])) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        boolean[] visited = new boolean[v + 1];
        pq.add(new Pair(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();

            if (visited[p.end]) {
                continue;
            }
            visited[p.end] = true;

            for (Pair el : list[p.end]) {
                if (cost[el.end] > cost[p.end] + el.cost) {
                    cost[el.end] = cost[p.end] + el.cost;
                    pq.add(new Pair(el.end, cost[el.end]));
                }
            }
        }
    }

}
