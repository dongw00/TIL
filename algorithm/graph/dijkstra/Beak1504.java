package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Beak1504 {

    static int n, e;
    static List<Node>[] list;
    static int[] dist;

    static final int INF = 200000001;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int res1 = dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> N
        int res2 = dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int ans = Math.min(res1, res2);
        System.out.println(ans >= INF ? -1 : ans);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            int idx = currentNode.end;

            if (check[idx]) {
                continue;
            }
            check[idx] = true;

            for (Node el : list[idx]) {
                if (!check[el.end] && dist[el.end] > dist[idx] + el.cost) {
                    dist[el.end] = dist[idx] + el.cost;
                    queue.add(new Node(el.end, dist[el.end]));
                }
            }
        }

        return dist[end];
    }
}
