package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Beak1916 {

    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static List<Node>[] list;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s);

        System.out.println(dist[e]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue();
        boolean[] check = new boolean[n + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            int idx = curNode.end;

            if (check[idx])
                continue;
            check[idx] = true;

            for (Node node : list[idx]) {
                if (dist[node.end] > dist[idx] + node.cost) {
                    dist[node.end] = dist[idx] + node.cost;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
