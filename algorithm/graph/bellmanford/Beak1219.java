package graph.bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1219 {

    static Edge[] edges;
    static long[] dist;
    static int[] city;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        edges = new Edge[m];
        dist = new long[n];
        city = new int[n];

        Arrays.fill(dist, Long.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, c);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        bellmanFord(start);

        if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (dist[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(dist[end]);
        }
    }

    public static void bellmanFord(int start) {
        dist[start] = city[start];

        for (int i = 0; i <= n + 50; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];

                if (dist[edge.start] == Long.MIN_VALUE) {
                    continue;
                }

                if (dist[edge.start] == Long.MAX_VALUE) {
                    dist[edge.end] = Long.MAX_VALUE;
                } else if (dist[edge.end] < dist[edge.start] + city[edge.end] - edge.cost) {
                    dist[edge.end] = dist[edge.start] + city[edge.end] - edge.cost;

                    if (i >= n - 1) {
                        dist[edge.end] = Long.MAX_VALUE;
                    }
                }
            }
        }
    }

    static class Edge {

        int start, end, cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
