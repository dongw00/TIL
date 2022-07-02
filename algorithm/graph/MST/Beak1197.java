package graph.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak1197 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        int[] parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        int res = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();

            if (getParent(parent, edge.start) != getParent(parent, edge.end)) {
                unionParent(parent, edge.start, edge.end);
                res += edge.weight;
            }
        }

        System.out.println(res);
    }

    private static int getParent(int[] arr, int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = getParent(arr, arr[x]);
    }

    private static void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    static class Edge {

        int start, end, weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

}
