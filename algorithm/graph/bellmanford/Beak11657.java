package graph.bellmanford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak11657 {

    static final int INF = Integer.MAX_VALUE;
    static Edge[] list;
    static long[] dist;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new Edge[m + 1];
        dist = new long[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[i] = new Edge(a, b, c);
        }

        Arrays.fill(dist, INF);

        bellmanFord(1);

        if (checkCycle()) {
            System.out.println(-1);
            return;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= n; i++) {
            if (dist[i] == INF) {
                bw.write("-1\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void bellmanFord(int start) {
        dist[start] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = list[j];

                if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;
                }
            }
        }
    }

    public static boolean checkCycle() {
        for (int i = 0; i < m; i++) {
            Edge edge = list[i];

            if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.cost) {
                return true;
            }
        }
        return false;
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
