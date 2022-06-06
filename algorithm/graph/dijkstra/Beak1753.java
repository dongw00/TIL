package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Beak1753 {

    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;

    static List<Node>[] list;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            int idx = curNode.end;

            if (check[idx])
                continue;
            check[idx] = true;

            for (Node el : list[idx]) {
                if (dist[el.end] > dist[idx] + el.weight) {
                    dist[el.end] = dist[idx] + el.weight;
                    queue.add(new Node(el.end, dist[el.end]));
                }
            }
        }
    }
}
